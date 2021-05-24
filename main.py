#DEFINES
def input_number(prompt) :
  print(prompt)
  while True :
      # Loop until a valid input is given: { n | n ∈ ℝ⁺ }
    try :
      inpt = int(input("\t"))
      if inpt > 0 :
        return inpt
      #end_if
    except ValueError :
      pass
    #end_try
  #end_while
#end_def

#INPUT
height  = input_number("Enter height of triangles:")
columns = input_number("Enter number of traingles per row:")
rows    = input_number("Enter number of rows:")

#PROCESS
for row in range(0, rows) :
  if row % 2 == 0 :
      # Computers iterate starting from 0
      # thus this part is actually for odd rows (#0, #2,…)
    length = 2*height-1
      # The number of '*'s for the longest line
    for line in range(0,height) :
        # For convention. Equivalent to (from row 1 to row last) - 1
      print( (' '*(line+1) + '*'*length + ' '*line) * columns )
        # <line> + 1 ' 's, <length> '*'s, and <line> ' 's
        #   +1 for an extra padding on the left
      length -= 2
        # each line has 1 less ' ' on each end and
        #   2 less '*' in the center.
    #end_for
  else :
      # thus this part is for even rows (#1, #3,…)
      # All is the same but this is the vertically flipped &
      #   character-swapped version for odd rows.
      # *****     *     *       *** *****
      #  ***  ->  **   ***  ->  **   ***
      #   *       *** *****     *     *
    length = 1
    for line in range(height-1,-1,-1) :
        # The original range is end-excluded, this reversing
        #   yields height-1 ~ 0, or range(height-1,0-1,-1)
      print( ('*'*(line+1) + ' '*length + '*'*line) * columns )
      length += 2
    #end_for
  #end_if
#end_for