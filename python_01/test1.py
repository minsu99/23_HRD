
str = "hello world"
print(str)


print("------------------------------------")
word = 'thud'
offset = 0
while offset < len(word):
	print(word[offset])
	offset += 1
	
print("-----------------------------------")
word = 'apple'
for letter in word:
	if letter == 'x':
		print("Eek! An 'x'!")
		break
	print(letter)
else:
		print("No 'x' in there")
			
	
print("-----------------------------------")

for x in range(0,3):
	print(x)
print("-----------------------------------")

for x in range(2,-1,-1):
	print(x)
	
numbers = {1,3,5}
position = 0
while position < len(numbers):
	number = numbers[position]
	if number % 2 == 0:
		print('Found even number', number)
		break
	position += 1
else:
		print('No even number found')
		
