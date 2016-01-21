elements = set(['H', 'He', 
			'Li', 'Be', 'B', 'C', 'N', 'O', 'F', 'Ne', 
			'Na', 'Mg', 'Al', 'Si', 'P', 'S', 'Cl', 'Ar',
			'K', 'Ca'])

def compound(str):
	is_compound = [False] * len(str)
	if len(str) == 0:
		return True
	if len(str) >= 1:
		is_compound[0] = str[0] in elements
	if len(str) >= 2:
		is_compound[1] = (
			(is_compound[0] and str[1] in elements)
			or str[0:2] in elements
			)
	for i in range(2, len(str)):
		is_compound[i] = (
			is_compound[i-1] and str[i] in elements
			or is_compound[i-2] and str[i-1:i+1] in elements
			)
	print is_compound
	return is_compound[-1]


str = "CaCaSiPClClArALiBeBBBeCNOFNe"
print compound(str)