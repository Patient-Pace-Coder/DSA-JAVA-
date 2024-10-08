package Stack;


    public class StackOfPlates1 {
        private int capacity;
        private int currentStack;
        private int[][] stacks;

        public StackOfPlates1(int capacity) {
            this.capacity = capacity;
            this.currentStack = 0;
            this.stacks = new int[1][capacity]; // Initial stack
        }

        public void push(int plate) {
            if (stacks[currentStack].length == capacity) {
                // Current stack is full, start a new stack
                int[][] newStacks = new int[stacks.length + 1][capacity];
                System.arraycopy(stacks, 0, newStacks, 0, stacks.length);
                stacks = newStacks;
                currentStack++;
            }

            // Push the plate onto the current stack
            stacks[currentStack][stacks[currentStack].length - 1] = plate;
        }

        public int pop() {
            if (stacks[currentStack].length == 0) {
                // Current stack is empty, move to the previous stack
                if (currentStack > 0) {
                    currentStack--;
                } else {
                    System.out.println("No plates to pop.");
                    return -1; // Indicates an empty stack
                }
            }

            // Pop the plate from the current stack
            int plate = stacks[currentStack][stacks[currentStack].length - 1];
            stacks[currentStack][stacks[currentStack].length - 1] = 0; // Assuming 0 is not a valid plate value
            return plate;
        }

        public static void main(String[] args) {
            StackOfPlates1 stack = new StackOfPlates1(3); // Each stack can hold up to 3 plates

            stack.push(1);
            stack.push(2);
            stack.push(3);

            stack.push(4); // This will start a new stack

            System.out.println(stack.pop()); // Pop from the current stack
            System.out.println(stack.pop()); // Pop from the current stack

            System.out.println(stack.pop()); // Pop from the previous stack
            System.out.println(stack.pop()); // Attempt to pop from an empty stack
        }
    }

