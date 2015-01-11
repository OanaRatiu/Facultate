import copy


def read_grammar_from_keyboard():
    nonterminals, terminals, productions = [], [], []
    len_nonterminals = int(raw_input('Enter length of set of nonterminals: '))
    print 'Enter set of nonterminals:'
    for i in range(1, len_nonterminals + 1):
        nonterminals.append(raw_input('Nonterminal %s -->' %i))

    len_terminals = int(raw_input('Enter length of set of terminals: '))
    print 'Enter set of terminals:'
    for i in range(1, len_terminals + 1):
        terminals.append(raw_input('Terminal %s -->' %i))
    
    len_productions = int(raw_input('Enter length of set of productions: '))
    print 'Enter set of productions:'
    for i in range(1, len_productions + 1):
        productions.append(raw_input('Production %s -->' %i))

    initial_state = raw_input('Enter initial state: ')
    return nonterminals, terminals, process_productions(productions)


def read_grammar_from_file():
    """
    The file should have in this order the elements:
    * first line with nonterminals
    * second line with terminals
    * third line initial state
    * rest of line with productions
    """
    nonterminals, terminals, productions = [], [], []
    with open("grammar", "r") as f:
        nonterminals = f.readline().split()
        terminals = f.readline().split()
        initial_state = f.readline().strip()
        productions = process_productions(f.readlines())
        return nonterminals, terminals, productions, initial_state


def read_automata_from_keyboard():
    states, alphabet, transitions, final_states = [], [], [], []
    len_states = int(raw_input('Enter length of set of states: '))
    print 'Enter set of states:'
    for i in range(1, len_states + 1):
        states.append(raw_input('State %s -->' %i))

    len_alphabet = int(raw_input('Enter length of set of alphabet: '))
    print 'Enter alphabet:'
    for i in range(1, len_alphabet + 1):
        alphabet.append(raw_input('Alphabet %s -->' %i))

    len_transitions = int(raw_input('Enter length of set of transitions: '))
    print 'Enter set of transitions: '
    for i in range(1, len_transitions + 1):
        transitions.append(raw_input('Transition %s -->' %i))

    len_final_states = int(raw_input('Enter length of set of final states: '))
    print 'Enter set of states:'
    for i in range(1, len_final_states + 1):
        final_states.append(raw_input('Final state %s -->' %i))

    initial_state = raw_input('Enter initial state: ')
    return states, alphabet, process_transitions(transitions), final_states, initial_state


def read_automata_from_file():
    """
    The file should have in this exact order the following
    * first line states
    * second line alphabet
    * third line final states
    * rest of the file transitions
    """
    states, alphabet, transitions, final_states = [], [], [], []
    with open("automata", "r") as f:
        states = f.readline().split()
        alphabet = f.readline().split()
        final_states = f.readline().split()
        initial_state = f.readline()
        transitions = process_transitions(f.readlines())
        return states, alphabet, transitions, final_states, initial_state


def process_productions(productions):
    result = {}
    for production in productions:
        lhs, rhs = production.strip().split('->')
        for r in rhs.split('|'):
            if not lhs in result.keys():
                result[lhs] = [list(r)]
            else:
                result[lhs].append(list(r))
    return result


def process_transitions(transitions):
    result = {}
    for transition in transitions:
        lhs, rhs = transition.strip().split(':')
        key = tuple(lhs.split(','))
        try:
            value = rhs.split(',')
        except:
            value = list(rhs)
        result[key] = value
    return result


def grammar_is_regular(nonterminals, terminals, productions):
    epsilon = True if '#' in terminals else False
    for key, value in productions.items():
        if key not in nonterminals:
            return False
        # parse each list in value (value is a list of lists)
        for v in value:
            if len(v) not in [1, 2]:
                return False
            if len(v) == 1 and v[0] not in terminals:
                return False
            if len(v) == 2:
                if v[0] not in terminals and v[1] not in nonterminals:
                    return False
                if epsilon and key in v:
                    return False
    return True


def get_productions(nonterminal_symbol, productions):
    production = productions.get(nonterminal_symbol)
    if production:
        print 'The productions of %s are: ' % nonterminal_symbol
        for p in production:
            print '%s -> %s' % (nonterminal_symbol, ''.join(p))
    else:
        print 'Symbol %s doesn\'t have any productions' % nonterminal_symbol


def display_grammar(nonterminals, terminals, productions, initial_state):
    print '****** REGULAR GRAMMAR ******'
    print 'Set of nonterminals: ', nonterminals
    print 'Set of terminals: ', terminals
    print 'Initial state: ', initial_state
    print 'Set of productions: '
    for key, value in productions.items():
        for v in value:
            print '%s -> %s' % (key, ''.join(v))


def display_automata(states, alphabet, transitions, final_states, initial_state):
    print '****** FINITE AUTOMATA ******'
    print 'Set of states:', states
    print 'Alphabet: ', alphabet
    print 'Final states: ', final_states
    print 'initial_state: ', initial_state
    print 'Transitions'
    for key, value in transitions.items():
        print '%s, %s -> %s' % (key[0], key[1], '|'.join(value))


def grammar_in_automata(nonterminals, terminals, productions, initial_state):
    """
    We need to compute M=(Q, E, f, q0, F) where:
        * Q = N U {k}, k not in N                   states
        * E - the same                              alphabet
        * q0 = S                                    initial state
        * F = k / {S,k}                             final states
        * f = {B/(A->aB) in P} U K                  transitions
    """
    states = copy.copy(nonterminals)
    states.append('k')
    alphabet = copy.copy(terminals)
    final_states = ['k']
    for value in productions[initial_state]:
        if '#' in value:
            final_states.append('#')
    transitions = {}
    for key, value in productions.items():
        for symbols in value:
            if len(symbols) == 2:
                if not transitions.get((key, symbols[0])):
                    transitions[(key, symbols[0])] = [symbols[1]]
                else:
                    transitions[(key, symbols[0])].append(symbols[1])
            elif len(symbols) == 1:
                if not transitions.get((key, symbols[0])):
                    transitions[(key, symbols[0])] = ['k']
                else:
                    transitions[(key, symbols[0])].append('k')
    display_automata(
        states, alphabet, transitions, final_states, initial_state
    )


def automata_in_grammar(states, alphabet, transitions, final_states, automata_initial_state):
    """
    We need to compute G=(N,E,P,S) where:
        * N = Q
        * S = q0
        * E - the same
        * P = {A->aB|f(A,a) in B} U {A->a|f(A,a) in B, B in F}
    """
    nonterminals = copy.copy(states)
    initial_state = automata_initial_state
    terminals = copy.copy(alphabet)
    productions = {}
    for key, value in transitions.items():
        b = set(value).intersection(final_states)
        if productions.get(key[0]):
            productions[key[0]].append([key[1], value[0]])
        else:
            productions[key[0]] = [key[1], value[0]]
        if b:
            productions[key[0]].append(key[1])
    if initial_state in final_states:
        if productions.get(initial_state):
            productions[initial_state].append('#')
        else:
            productions[initial_state] = ['#']
    display_grammar(nonterminals, terminals, productions, initial_state)


def display_menu():
    print '1 - Read regular grammar from keyboard '
    print '2 - Read regular grammar from file'
    print '3 - Grammar is regular'
    print '4 - Check productions'
    print '5 - Read finite automata from keyboard'
    print '6 - Read finite automata from file'
    print '7 - Display regular grammar'
    print '8 - Display finite automata'
    print '9 - From regular grammar into finite automata'
    print '10- From finite automata into regular grammar'
    print '0 - EXIT'

if __name__ == '__main__':
    display_menu()
    option_type = int(raw_input())
    while option_type != 0:
        if option_type == 1:
            nonterminals, terminals, productions, grammar_initial_state = read_grammar_from_keyboard()
        elif option_type == 2:
            nonterminals, terminals, productions, grammar_initial_state = read_grammar_from_file()
        elif option_type == 3:
            regular = grammar_is_regular(nonterminals, terminals, productions)
            print 'Grammar is regular!' if regular else 'Grammar is not regular!'
        elif option_type == 4:
            symbol = raw_input('Give symbol: ') 
            get_productions(symbol, productions)
        elif option_type == 5:
            states, alphabet, transitions, final_states, automata_initial_state = read_automata_from_keyboard()
        elif option_type == 6:
            states, alphabet, transitions, final_states, automata_initial_state = read_automata_from_file()
        elif option_type == 7:
            display_grammar(nonterminals, terminals, productions, grammar_initial_state)
        elif option_type == 8:  
            display_automata(states, alphabet, transitions, final_states, automata_initial_state)
        elif option_type == 9:
            grammar_in_automata(nonterminals, terminals, productions, grammar_initial_state)
        elif option_type == 10:
            automata_in_grammar(states, alphabet, transitions, final_states, automata_initial_state)
        display_menu()
        option_type = int(raw_input())
