#DEFINES
def input_number(prompt)
  puts(prompt)
  loop do
      # Loop until a valid input is given: { n | n ∈ ℝ⁺ }
    print("\t")
    begin
      inpt = Integer(gets().chomp)
      return inpt if inpt > 0
    rescue
    end
  end
end

#INPUT
height  = input_number("Enter height of triangles:")
columns = input_number("Enter number of traingles per row:")
rows    = input_number("Enter number of rows:")

#PROCESS
rows.times do |row|
  if row.even?
      # Computers iterate starting from 0
      # thus this part is actually for odd rows (#0, #2,…)
    length = 2*height-1
      # The number of '*'s for the longest line
    (0...height).each do |line|
        # For convention. Equivalent to (from row 1 to row last) - 1
      puts( (' '*(line+1) + '*'*length + ' '*line) * columns )
        # <line> + 1 ' 's, <length> '*'s, and <line> ' 's
        #   +1 for an extra padding on the left
      length -= 2
        # each line has 1 less ' ' on each end and
        #   2 less '*' in the center.
    end
  else
      # thus this part is for even rows (#1, #3,…)
      # All is the same but this is the vertically flipped &
      #   character-swapped version for odd rows.
      # *****     *     *       *** *****
      #  ***  ->  **   ***  ->  **   ***
      #   *       *** *****     *     *
    length = 1
    (0...height).reverse_each do |line|
      puts( ('*'*(line+1) + ' '*length + '*'*line) * columns )
      length += 2
    end
  end
end

# 🙂
true