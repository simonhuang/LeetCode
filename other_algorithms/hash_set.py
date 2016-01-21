
class HashSet:
	collision_rate = 0.3

	def __init__(self):
		self.size = 10
		self.count = 0
		self.buckets = [[] for i in range(self.size)]

	def insert(self, val):
		index = self.hash(val)
		bucket = self.buckets[index]
		if val in bucket:
			return
		bucket.append(val)
		self.count = self.count + 1
		if float(self.count) / self.size > HashSet.collision_rate:
			self.resize()

	def contains(self, val):
		index = self.hash(val)
		return val in self.buckets[index]

	def remove(self, val):
		index = self.hash(val)
		bucket = self.buckets[index]
		if val in bucket:
			bucket.remove(val)



	def resize(self, factor):
		print 'resize'
		self.size = self.size * factor
		new_buckets = [[] for i in range(self.size)]

		for b in self.buckets:
			if b is not None:
				for val in b:
					new_buckets[self.hash(val)].append(val)

		self.buckets = new_buckets


	def hash(self, val):
		index = val % self.size
		return index

set = HashSet()
set.insert(5)
set.insert(4)
set.insert(-5)
set.insert(6)
print set.buckets

print set.contains(5), set.contains(3)