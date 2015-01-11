import re

# the codes for PIF
codes = {
    'program': 2,
    'var': 3,
    'const': 4,
    'array': 5,
    'int': 6,
    'char': 7,
    'string': 8,
    'while': 9,
    'do': 10,
    'if': 11,
    'then': 12,
    'else': 13,
    'read': 14,
    'write': 15,
    '{': 16,
    '}': 17,
    '(': 18,
    ')': 19,
    '<': 20,
    '<=': 21,
    '>=': 22,
    '>': 23,
    '!=': 24,
    '==': 25,
    '=': 26,
    '+': 27,
    '-': 28,
    '*': 29,
    '/': 30,
    ';': 31,
    '.': 32,
    '"': 33,
    "of": 34,
    "char": 35,
    "int": 36,
    "string": 37,
    ":": 38,
    "'": 39,
    '[': 40,
    ']': 41
}

errors = []
PIF = []
# lexicographically sorted table - a list of touples (id, symbol)
symbol_table_identifiers = []
symbol_table_constants = []


def open_file(file):
    """
    Read every line in file and compile it, filling the symbol tables and PIF.
    The errors will be in errors list.
    The file must be split in 2 parts: the declaration list and the statements.
    """
    with open(file, 'r') as f:
        try:
            declaration, statements = f.read().split('{', 1)
        except:
            errors.append(
                "File is not complete! " +
                "Declaration list and/or statements are missing."
            )
        line_count = compile_declaration(declaration, 0)
        PIF.append((codes['{'], -1))
        compile_statements(statements, line_count)


def compile_declaration(declaration, line_count):
    line_count += len(declaration.split("\n"))
    declaration = re.sub(r" |\n", "", declaration)
    tokens = declaration.split(';')
    for token in tokens:
        if token != '\r':
            identifiers = token.split(':')
            # we add the identifier
            index = add_identifier(identifiers[0])
            add_in_PIF(index, 0)
            # then we add :
            add_in_PIF(':')
            # then we add the type
            add_in_PIF(identifiers[1])
            # then we add ";"
            add_in_PIF(';')
    make_regular_grammar(declaration)
    return line_count


def make_regular_grammar(declaration):
    pass


def add_production_to_grammar(tokens):
    pass


def add_identifier(identifier):
    index = len(symbol_table_identifiers)
    add_identifier_to_identifiers_table(identifier, index)
    return index


def add_constant(constant):
    index = len(symbol_table_constants)
    add_constant_to_constants_table(constant, index)
    return index


def add_in_PIF(identifier, identifier_index=None):
    """
    PIF will be of the form: [ (code, type) , ...],
    where code is the code of the identifier in codes and
    type is the type of de identifier or -1 for reserved words
    identifier_index - the index of the identifier in symbol_table_identifiers
    identifier - the token itself
    0 for identifier, 1 for constant
    """
    if identifier in codes.keys():
        PIF.append((codes[identifier], -1))
    else:
        PIF.append((identifier_index, identifier))


def binary_search_index(sorted_list, element, low_limit=0, high_limit=None):
    """
    If the element is already in the list, it returns the index of the element.
    Else, it returns the index after which we have to do the insertion.
    sorted_list is a list of touples: ('word', number)
    """
    if high_limit is None:
        high_limit = len(sorted_list)
    while low_limit < high_limit:
        middle = (low_limit+high_limit)/2
        if sorted_list[middle][0] < element:
            low_limit = middle + 1
        elif sorted_list[middle][0] > element:
            high_limit = middle
        else:
            return -1
    return low_limit


def add_identifier_to_identifiers_table(identifier, index):
    """
    Add the identifier in the right position in symbol_table_identifiers,
    but also remebering the index.
    If there is already an identifier, we will not put in the the PIF.
    """
    index_to_insert = binary_search_index(symbol_table_identifiers, identifier)
    if index_to_insert != -1:
        symbol_table_identifiers.insert(index_to_insert, (identifier, index))


def add_constant_to_constants_table(constant, index):
    """
    Add the constant in the right position in symbol_table_identifiers,
    but also remebering the index.
    If there is already an constant, we will not put in the the PIF.
    """
    index_to_insert = binary_search_index(symbol_table_constants, constant)
    if index_to_insert != -1:
        symbol_table_constants.insert(index_to_insert, (constant, index))


def validate_identifier(identifier, line):
    identifier = identifier.replace('\r', '')
    if identifier:
        try:
            identifier = re.match('(^[a-zA-Z]+[0-9]*$)', identifier).group(1)
        except:
            errors.append(
                'Variable name is not correct! ' +
                'It needs to be of the form letter | ' +
                'letter{letter}{digit}! Line %s: %s' % (line, identifier)
            )


def validate_constant(constant, line):
    try:
        if len(constant) != 1:
            constant = re.match('(^[1-9][0-9]*$)', constant).group(1)
    except:
        errors.append(
            'Constant is not correct! ' +
            'It needs to be composed of digits ' +
            'and not starting with 0! Line %s' % line
        )


def validate_string(constant, line):
    try:
        constant = re.match('(^[a-zA-Z]+[0-9]*$)', constant).group(1)
    except:
        errors.append(
            'Constant is not correct! ' +
            'It needs to contain only letters and digits! Line %s' % line
        )


def validate_operator(operator, line):
    if operator[0] == '+' or operator[0] == '-':
        if operator[1] == '0':
            errors.append(
                'Number 0 cannot have + or - in front! Line %s' % line
            )


def compile_statements(statements, line_count):
    """
    Entire statement.
    """
    statements_list = statements.split('\n')
    operators = [
        '==', '!=', '<', '>', '>=', '<=', '=',
        '(', ')', '+', '-', '/', '*', '{', '}',
        ';', '.', "'"
    ]
    for line, statement in enumerate(statements_list):
        while statement:
            statement = statement.replace(' ', '')
            slice_counter = 0
            if statement.startswith('if'):
                add_in_PIF('if')
                slice_counter = 2
            elif statement.startswith('while'):
                add_in_PIF('while')
                slice_counter = 5
            elif statement.startswith('then'):
                add_in_PIF('then')
                slice_counter = 4
            elif statement.startswith('read'):
                add_in_PIF('read')
                slice_counter = 4
            elif statement.startswith('write'):
                add_in_PIF('write')
                slice_counter = 5
            elif statement[0] == "'":
                add_in_PIF(statement[0])
                slice_counter = 1
                try:
                    char = re.match(
                        '(^[a-zA-Z]|[0-9])', statement[1:]
                        ).group(1)

                    if statement[2] == "'":
                        i = add_constant(char)
                        add_in_PIF(i, 1)
                        slice_counter += 1
                        add_in_PIF(statement[0])
                        slice_counter += 1
                    else:
                        errors.append(
                            'Char must end with "\'". ' +
                            'Line %s' % str(line_count)
                        )
                except:
                    pass
            # this is for ==, !=, >=, <=
            # len cond: if s='a' => s[:2] == 'a' <- nu conteaza ca
            # are doar un singur caracter, il returneaza oricum
            elif statement[:2] in operators and len(statement) >= 2:
                add_in_PIF(statement[:2])
                slice_counter = 2
            # this is for other operators
            elif statement[0] in operators:
                validate_operator(statement[:2], str(line_count))
                try:
                    constant = re.match('(^[0-9]+)', statement[1:]).group(1)
                    slice_counter = 1
                    if statement[0] == '+' or statement[0] == '-':
                        i = add_constant(statement[0]+constant)
                        add_in_PIF(i, 1)
                        slice_counter = len(constant) + 1
                    else:
                        add_in_PIF(statement[0])
                except:
                    add_in_PIF(statement[0])
                    slice_counter = 1
            elif statement[0] == '"':
                add_in_PIF(statement[0])
                index = statement[1:].find('"')
                validate_string(statement[1:index+1], str(line_count))
                i = add_constant(statement[1:index+1])
                add_in_PIF(i, 1)
                add_in_PIF(statement[0])
                slice_counter = index + 2
            elif re.match('(^[\s]*[0-9]+)', statement):
                constant = re.match('(^[\s]*[0-9]+)', statement).group(1)
                validate_constant(constant, str(line_count))
                index = add_constant(constant)
                add_in_PIF(index, 1)
                slice_counter = 1
            else:
                identifier = re.match('([^+-=!/:(){}\n]*)', statement).group(1)
                if statement.startswith(identifier):
                    exists = [
                        index for id, index in symbol_table_identifiers
                        if id == identifier
                    ]
                    validate_identifier(identifier, str(line_count))
                    if exists:
                        add_in_PIF(exists[0], 0)
                    slice_counter = len(identifier)
            statement = statement[slice_counter:]
        line_count += 1


if __name__ == '__main__':
    open_file('test')
    print "symbol", symbol_table_identifiers
    print "cts", symbol_table_constants
    print "pif", PIF[:10]
    print PIF[10:20]
    print PIF[20:30]
    print PIF[30:40]
    print PIF[40:]
    for error in errors:
        print 'err', error
