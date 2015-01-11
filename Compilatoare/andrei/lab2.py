import os
import re

grammar = None
separate_words = re.compile('[^_]+')

def get_printable(str):
	return " ".join([word for word in separate_words.findall(str)])

def _read_int(str):
	try:
		return int(raw_input(str))
	except ValueError:
		pass

def read_gr_key():
	pass

def read_gr_file():
	global grammar
	file_path = raw_input("file path: ")
	# file exists?
	print "processing..."

	with open(file_path, "r") as grammar_file:
		line = grammar_file.readline()
		non_terminals = [symbol for symbol in line.split()]

		line = grammar_file.readline()
		terminals = [symbol for symbol in line.split()]

		productions = []
		for line in grammar_file:
			# get parent
			toks = line.split("->")
			parent = toks[0]

			# get children
			toks = toks[1].split("|")
			prod = {parent: toks}

			productions.append(prod)

	grammar = {"non-term": non_terminals, "term": terminals, "prds": productions}

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

		p_str = "%s -> %s\n" % "|".join([term for term in grammar['prds'][prd]])
		string = "%s\n%s" % (string, p_str)

	print string

def print_menu():
	index = 1
	for key in functions:
		print "%s -- %s" % (index, get_printable(key))
		index = index + 1

functions  = {'read_grammar_from_keyboard': read_gr_key, \
			  'read_grammer_from_file': read_gr_file, \
			  'print terminals': print_terminals, \
			  'print non_terminals': print_non_terminals, \
			  'print_productions': print_productions, \
			  'exit': exit}


def main():
	print_menu()
	function_names = [key for key in functions]
	while True:
		command = raw_input(">>> ")
		key = function_names[int(command) - 1]

		if key in functions:
			functions[key]()
		else:
			print "no such command: %s" % command


if __name__ == "__main__":
	main()