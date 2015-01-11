import copy
import re

auto = None
grammar = None
separate_words = re.compile('[^_]+')
items = {}


def get_printable(str):
    return " ".join([word for word in separate_words.findall(str)])


def _read_int(str):
    try:
        return int(raw_input(str))
    except ValueError:
        pass


def read_gr_file():
    global grammar
    #file_path = raw_input("file path: ")
    # file exists?
    file_path = 'grammar'

    with open(file_path, "r") as grammar_file:
        line = grammar_file.readline().strip()
        non_terminals = [symbol for symbol in line.split()]

        line = grammar_file.readline().strip()
        terminals = [symbol for symbol in line.split()]

        productions = []
        for line in grammar_file:
            line = line.strip()
            # get parent
            toks = line.split("->")
            parent = toks[0]

            # get children
            toks = toks[1].split("|")
            prod = {parent: [[ind_term for ind_term in term] for term in toks]}

            productions.append(prod)

    grammar = {
        "non-term": non_terminals, "term": terminals, "prds": productions}


def print_terminals():
    if grammar is None:
        print "No grammar is loaded"
        return

    str = ", ".join([term for term in grammar["term"]])
    print str


def print_non_terminals():
    if grammar is None:
        print "No grammar is loaded"
        return

    str = ", ".join([non_term for non_term in grammar["non-term"]])
    print str


def print_productions():
    if grammar is None:
        print "No grammar is loaded"
        return

    string = ""
    for prd in grammar["prds"]:
        key = prd.keys()[0]

        prd_str = "%s -> " % key
        str_list = ["".join(let_list) for let_list in prd[key]]
        prd_str = "%s %s" % (prd_str, "|".join(str_list))
        string = "%s%s\n" % (string, prd_str)

        targets = []
        for tar in prd[key]:
            targets.append(tar[0])
            if len(tar) == 2:
                targets.append(tar[1])
            else:
                targets.append('')

        for index, val in enumerate(targets):
            if index % 2 == 1:
                if val in auto['final_states']:
                    print "%s -> %s" % (key, targets[index - 1])

    print string


def format_productions(prod):
    productions = copy.copy(prod)
    for p in productions:
        for key, values in p.items():
            for i in range(len(values)):
                p[key][i] = ''.join(values[i])
    return productions


def add_in_closure(c, item):
    """
    item will be of the form {S:a.A}
    and closure {S:[a.A, b.B]}
    """
    i_key = item.keys()[0]
    i_value = item[item.keys()[0]]
    if '.' not in i_value:
        i_value = '.' + i_value
    if i_key not in c.keys():
        c[i_key] = [i_value]
    if i_key in c.keys():
        if i_value not in c[i_key]:
            c[i_key].append(i_value)


def get_symbol(element):
    if '.' not in element:
        return element
    if element.startswith('.'):
        return element[1]
    return element.split('.')[1]


def get_closure(element):
    """
    element must be of form {S:a.A}
    each element of items will look like:
    'A': [alphaX.beta], for each X in N U E
    """
    if '.' not in element[element.keys()[0]]:
        c = {element.keys()[0]: ['.' + element[element.keys()[0]]]}
    else:
        c = {element.keys()[0]: [element[element.keys()[0]]]}
    copy_c = {}
    productions = format_productions(grammar['prds'])
    symbol = get_symbol(element[element.keys()[0]])
    while c != copy_c:
        copy_c = copy.copy(c)
        for production in productions:
            for key, value in production.items():
                if key == symbol:
                    add_in_closure(c, {key: ''.join(value)})
    return c


def move_dot(element):
    for i in range(len(element)-1):
        if element[i] == '.':
            element = list(element)
            element[i], element[i+1] = element[i+1], element[i]
            return ''.join(element)
    return ''


def goto(state):
    """
    s - state of the form s0, s1.., where s0 list of analyses elements
    X - symbol
    """
    result = []
    processed = []
    for key, value in state.items():
        if key == 'index':
            continue
        for v in value:
            if v.endswith('.'):
                result.append({key: [v]})
                continue
            processed.append(get_symbol(v))
            v = move_dot(v)
            result.append(get_closure({key: v}))
    return result, processed


def check_if_dict_in_value(closure, states_value):
    """
    states_value will be of form:
    {'S': ['.aA'], 'S1': ['.S']}
    closure will be of form:
    {'S': ['.aA']}
    """
    for numbered_state, states in states_value.items():
        for key, value in states.items():
            if {key: value} == closure:
                return numbered_state
    return None


def col_states():
    """
    return the canonical collection of states
    """
    canonical_coll = []
    s0 = get_closure({'S1': 'S'})
    canonical_coll.append(s0)
    copy_coll = {}
    states_dict = {str({'S1': 'S'}): [({key: value}, get_symbol(value[0]))
                                      for key, value in s0.items()]}
    states_mapping = {0: s0}
    states_index = 1

    goto_dict = {0: [({'S1': '.S'}, 'init')]}

    while canonical_coll != copy_coll:
        canonical_coll_tmp = []
        copy_coll = copy.deepcopy(canonical_coll)

        for coll in canonical_coll:
            for key, value in coll.items():
                states, processed = goto({key: value})
                if not states_dict.get(str({key: value})):
                    states_dict[str({key: value})] = []
                index = 0
                for cl in states:
                    if (cl not in canonical_coll and
                            cl not in canonical_coll_tmp):
                        canonical_coll_tmp.append(cl)
                        states_dict[str({key: value})].append(
                            (cl, processed[index]))
                        states_mapping[states_index] = cl
                        nr = check_if_dict_in_value({key: value},
                                                    states_mapping)
                        if nr >= 0:
                            if goto_dict.get(states_index) is not None:
                                goto_dict[states_index].append(
                                    (nr, processed[index]))
                            else:
                                goto_dict[states_index] = [(nr, processed[index])]
                        states_index += 1
                        index += 1

        canonical_coll.extend(canonical_coll_tmp)
    return canonical_coll, states_dict, goto_dict


def get_numbered_production():
    productions = format_productions(grammar['prds'])
    numbered_productions = {}
    index = 1

    for production in productions:
        for key, values in production.items():
            for value in values:
                numbered_productions['%s->%s' % (key, value)] = index
                index += 1

    return numbered_productions


def symbol_is_in_goto_dict(goto_dict, symbol):
    appeareances = 0
    for key in sorted(goto_dict):
        for value in goto_dict[key]:
            if value[1] == symbol:
                appeareances += 1
    return appeareances


def get_state_number(goto_dict, symbol):
    for key in sorted(goto_dict):
        for value in goto_dict[key]:
            if value[1] == symbol:
                if symbol_is_in_goto_dict(goto_dict, symbol) != 1:
                    del goto_dict[key]
                return key


def analyses_table(canonical_coll, table, goto_dict):
    """
    [{"actiune": "", 'goto': {'symbol': ..., }}, ]
    """
    analyses_table = []
    state_index = 0
    for coll in canonical_coll:
        row = {'state_index': state_index, 'action': None, 'goto': {}}
        state_index += 1
        for key, values in coll.items():
            for index, value in enumerate(values):
                if value.endswith('.'):
                    format_val = value.replace('.', '')
                    if format_val == 'S':
                        row['action'] = 'acc'
                    else:
                        numb_prds = get_numbered_production()
                        row['action'] = (
                            'r%s' % numb_prds['%s->%s' % (key, format_val)])
                else:
                    row['action'] = 's'
                    symbol = get_symbol(value)
                    index = get_state_number(goto_dict, symbol)
                    row['goto'][symbol] = index
        analyses_table.append(row)
    return analyses_table


def get_state(goto, symbol):
    for key, value in goto['goto'].items():
        if key == symbol:
            return value
    return None


def get_production(productions, symbol):
    for key, value in productions.items():
        left_side, right_side = key.split('->')
        if symbol in right_side:
            return (left_side, value)
    return ('', '')


def get_state_symbol_goto(goto_dict, symbol, state_index):
    for state in goto_dict:
        if state['state_index'] == state_index:
            for key, value in state['goto'].items():
                if symbol in key:
                    return value
    return ''


def LR0(goto_dict, sequence):
    productions = get_numbered_production()
    productions['S1->S'] = 0
    # j - index of where we are in sequence
    j, state_number, stack, out = 0, 0, '$0', ''
    termination = False
    while not termination:
        state = [goto for goto in goto_dict
                 if goto['state_index'] == state_number][0]
        if state['action'] == 's':
            state_number = get_state(state, sequence[j])
            stack += sequence[j] + str(state_number)
            j += 1
        else:
            if state['action'][0] == 'r':
                # is terminal/ nontermnial
                # for the case: $0a2b3b3->$0a2b3b3A6 and $0a2b3b3c4->$0a2b3b3
                stack, symbol = stack[:-2], stack[-2]
                if symbol.islower():
                    prod_rhs, t = get_production(productions, symbol)
                    state_of_prod_rhs = get_state_symbol_goto(
                        goto_dict, prod_rhs, int(stack[len(stack)-1]))
                    stack += prod_rhs + str(state_of_prod_rhs)
                else:
                    prod_rhs, t = get_production(
                        productions, stack[len(stack)-2])
                    stack = stack[:-2]
                    state_of_prod_rhs = get_state_symbol_goto(
                        goto_dict, prod_rhs, int(stack[len(stack)-1]))
                    stack += prod_rhs + str(state_of_prod_rhs)
                out = str(t) + out
                state_number = state_of_prod_rhs
            elif state['action'] == 'acc':
                termination = True
    print 'SUCCESS'
    print 'input sequence: ', sequence
    print 'output productions: ', out


if __name__ == "__main__":
    read_gr_file()
    coll, table, goto_dict = col_states()
    table = analyses_table(coll, table, goto_dict)
    LR0(table, 'abbc')
