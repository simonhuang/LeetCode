
f = open('test.txt', 'r')

input = f.read().splitlines()

nodes = int(input[0])
edges = int(input[1])

edge_info = []
for i in range(2, 2+edges):
	edge = input[i].split(' ')
	for i in range(len(edge)):
		edge[i] = int(edge[i])
	edge_info.append(edge)

distance = [None for i in range(nodes)]

distance[1] = 0
for i in range(nodes):
	for e in edge_info:
		if distance[e[0]] is not None:
			if distance[e[1]] is None:
				distance[e[1]] = distance[e[0]] + e[2]
			else:
				distance[e[1]] = min(distance[e[1]], distance[e[0]] + e[2])

print distance