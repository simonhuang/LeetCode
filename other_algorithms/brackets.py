

def balanced(str):
	stack = []
	for c in str:
		if c == '(' or c == '[' or c == '{':
			stack.append(c)
		elif c == ')':
			if not c or stack[-1] != '(':
				return False
			else:
				stack.pop()
		elif c == ']':
			if not c or stack[-1] != '[':
				return False
			else:
				stack.pop()
		elif c == '}':
			if not c or stack[-1] != '{':
				return False
			else:
				stack.pop()
	return not stack


input = raw_input()
print balanced(input)