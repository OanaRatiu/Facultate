import re

# the codes for PIF
codes = {'program': 2, 
		 'var': 3, 'const': 4,
		 'array': 5,
		 'int': 6, 'char': 7, 'string': 8,
         'while': 9, 'do': 10, 'if': 11, 'then': 12 ,'else': 13,
         'read': 14, 'write': 15, 
         '{': 16, '}': 17, 
         '(': 18, ')': 19,
         '<': 20, '<=': 21, '>=': 22, '>': 23,
         '!=': 24, '==': 25,
         '=': 26,
         '+': 27, '-': 28, '*': 29, '/': 30, 
         ';': 31, '.': 32, '"': 33, "of": 34}

errors = []
PIF = []
# lexicographically sorted table - a list of touples (id, symbol)
symbol_table_identifiers = []
symbol_table_cosntants = []

def open_file(file):
	"""
	Read every line in file and compile it, filling the symbol tables and PIF.
	The errors will be in errors list.
	The file must be split in 2 parts: the declaration list and the statements.
	"""
	with open(file, 'r') as f:
		try:
			declarations, statements = f.read().split('{', 1)
		except:
			errors.append("File is not complete! Declaration list and/or statements are missing.")
		#try:
		compile_declarations_list(declarations)
		PIF.append((codes['{'], -1))
		compile_statements_list(statements[:-1])
		PIF.append((codes['}'], -1))
		PIF.append((codes['.'], -1))
		# except Exception as e:
		# 	errors.append(e.message)

def compile_declarations_list(declarations_string):
	"""
	Compile the first part of the file, in which every variable is declared.
	"""
	# we separate everything by ';', resulting in declarations
	# we remove extra-spaces
	declarations_list = declarations_string.split(';')
	for declaration in declarations_list:
		try:
			if declaration is not ' ':
				identifier, identifier_type = validate_declaration(declaration.strip())
				index = len(symbol_table_identifiers)
				add_identifier(identifier, index)
				PIF.append((index, codes[identifier_type]))
		except Exception as e:
			errors.append(e.message)


def validate_declaration(declaration):
	declaration = re.sub(r" ", "", declaration)
	identifier, identifier_type = declaration.split(':')
	try: 
		identifier = re.match('(^[a-zA-Z]+[0-9]*$)', identifier).group(1)
	except:
		raise Exception('Variable name is not correct! It needs to be of the form letter | letter{letter}{digit}!')
	try:
		identifier_type = re.match('(char|int|string|array\[[0-9]+\]of(char|int|string))', identifier_type).group(1)
	except:
		raise Exception('Type is not correct!')
	return identifier, identifier_type


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


def add_identifier(identifier, index):
	"""
	Add the identifier in the right position in symbol_table_identifiers,
	but also remebering the index.
	If there is already an identifier, we will not put in the the PIF.
	"""
	index_to_insert = binary_search_index(symbol_table_identifiers, identifier)
	if index_to_insert == -1:
		raise Exception("There is already an identifier '%s'" % identifier)
	symbol_table_identifiers.insert(index_to_insert, (identifier, index))

def add_constant(constant, index):
	"""
	Add the constant in the right position in symbol_table_identifiers,
	but also remebering the index.
	If there is already an constant, we will not put in the the PIF.
	"""
	index_to_insert = binary_search_index(symbol_table_cosntants, constant)
	if index_to_insert == -1:
		raise Exception("There is already a constant '%s'" % constant)
	symbol_table_cosntants.insert(index_to_insert, (constant, index))


def compile_statements_list(statements_string):
	acolades_count = 0
	statements_list = statements_string.split('\n')
	for statement in statements_list:
		if statement.startswith('if'):
			PIF.append((codes['if'], -1))
			compile_if_statement(statement)


def compile_if_statement(statement):
	# remove if from statement
	statement = statement[2:]
	# check if statement without if begins with identifier

	# identifier = re.match('(^[\s]*[a-zA-Z]+[0-9]*)', statement)
	# if identifier:
	# 	identifier = identifier.group(1)
	# 	without_identifier = len(identifier)
	# 	check_and_add_identifier(identifier.strip())
	# 	statement = statement[without_identifier:]
	

	# check if statement without if begins with constant

	# constant = re.match('(^[\s]*[0-9]+)', statement)
	# if constant:
	# 	constant = constant.group(1)
	# 	without_constant = len(constant)
	# 	check_and_add_constant(constant.strip())
	# 	statement = statement[without_constant:]

	# if after 'if' word an identifier or constant does not appear, we add an error
	# if not (identifier or constant):
	# 	errors.append('If statement cannot begin without an identifier or a constant!')
	statement = match_identifier(statement) or match_constant(statement)
	statement = statement.strip()
	then_index = statement.find('then')
	match_expression(statement[:then_index])
	statement = statement[(then_index + 4):]
	PIF.append((codes['then'], -1))
	match_compound_statement(statement)


def match_compound_statement(statement):
	if statement.startswith('{'):
		PIF.append((codes['{'], -1))
		if not statement.endswith('}'):
			errors.append('Acolade is missing!')
		statement = statement[1:-1]
	if statement.startswith('if'):
		compile_if_statement(statement)
	statement = match_assignment(statement)
	
	PIF.append((codes['}'], -1))


def match_assignment(statement):
	statement = match_identifier(statement)
	PIF.append((codes['='], -1))
	# remove the last ";"
	statement = match_expression(statement[:-1])
	PIF.append((codes[';'], -1))
	return statement


def match_expression(statement):
	while statement:
		character = statement[0]
		if character in ['(', ')', '-', '+', '/', '*']:
			PIF.append((codes[character], -1))
		else:
			if character not in ['=']:
				errors.append('You cannot have two identifiers and/or constants one after another')
		statement = match_identifier(statement[1:]) or match_constant(statement[1:])
		if not (statement or character):
			errors.append('You cannot have two operators one after another')
	return statement

def match_identifier(statement):
	identifier = re.match('(^[\s]*[a-zA-Z]+[0-9]*)', statement)
	if identifier:
		identifier = identifier.group(1)
		without_identifier = len(identifier)
		check_and_add_identifier(identifier.strip())
		return statement[without_identifier:]
	return None

def match_constant(statement):
	constant = re.match('(^[\s]*[0-9]+)', statement)
	if constant:
		constant = constant.group(1)
		without_constant = len(constant)
		check_and_add_constant(constant.strip())
		return statement[without_constant:]
	return None

def check_and_add_identifier(identifier):
	exists = False
	for identifier_name, identifier_type in symbol_table_identifiers:
		if identifier_name == identifier:
			exists = True
			type_code = [id_type for id_name, id_type in PIF if id_name==identifier_type][0]
			PIF.append((identifier_type, type_code))
	if not exists:
		errors.append('You cannot use an identifier that was not declared!!')
		return False
	return True

def check_and_add_constant(constant):
	exists = False
	for id, id_type in symbol_table_cosntants:
		if id == constant:
			exists = True
	if not exists:
		add_constant(constant, len(symbol_table_cosntants))
	PIF.append((constant, 0))
	return True


if __name__ == '__main__':
	# try:
	# 	open_file('test')
	# except Exception as e:
	# 	errors.append(e.message)
	open_file('test')
	print "symbol", symbol_table_identifiers
	print "cts", symbol_table_cosntants
	print "pif",PIF, len(PIF)
	print 'err', errors