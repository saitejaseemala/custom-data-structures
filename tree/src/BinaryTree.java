import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BinaryTree {

  private Node root;

  public BinaryTree() {}

  public static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  public void preOrder() {
    preOrder(root);
  }

  public void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + "\t");
    preOrder(node.left);
    preOrder(node.right);
  }

  public void preOrderTraversalIteratively() {
    Stack<Node> stack = new Stack<>();
    if (root == null) return;
    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      System.out.print(node.data + "\t");
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
  }

  public void inOrder() {
    inOrder(root);
  }

  public void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.data + "\t");
    inOrder(node.right);
  }

  public void inOrderTraversalIteratively() {
    Stack<Node> stack = new Stack<>();
    if (root == null) return;
    Node curr = root;
    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      System.out.print(curr.data + "\t");
      curr = curr.right;
    }
  }

  public void postOrder() {
    postOrder(root);
  }

  public void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data + "\t");
  }

  public void postOrderTraversalIteratively() {
    if (root == null) return;
    Stack<Node> stk1 = new Stack<>();
    Stack<Node> stk2 = new Stack<>();
    stk1.push(root);
    Node curr;
    while (!stk1.isEmpty()) {
      curr = stk1.pop();
      stk2.push(curr);
      if (curr.left != null) {
        stk1.push(curr.left);
      }
      if (curr.right != null) {
        stk1.push(curr.right);
      }
    }
    while (!stk2.isEmpty()) {
      curr = stk2.pop();
      System.out.print(curr.data + "\t");
    }
  }

  public void postOrderUsingOneStack() {
    Node node = root;
    if (node == null) return;

    Stack<Node> stack = new Stack<>();
    Node lastVisitedNode = null;

    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        // Traverse the left subtree
        stack.push(node);
        node = node.left;
      } else {
        Node peekNode = stack.peek();
        // If right child exists, and we have not yet visited it
        if (peekNode.right != null && lastVisitedNode != peekNode.right) {
          node = peekNode.right; // Move to right child
        } else {
          // Visit the node
          System.out.print(peekNode.data + "\t");
          lastVisitedNode = stack.pop(); // Pop the node from the stack
        }
      }
    }
  }

  public void levelOrderTraversal() {
    Queue<Node> queue = new LinkedList<>();
    if (root == null) return;
    queue.add(root);
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      System.out.print(curr.data + "\t");
      if (curr.left != null) {
        queue.add(curr.left);
      }
      if (curr.right != null) {
        queue.add(curr.right);
      }
    }
  }

  public void populate(Scanner sc) {
    System.out.println("Enter root node ");
    int val = sc.nextInt();
    System.out.println("value of root node " + val);
    root = new Node(val);
    populate(root, sc);
  }

  private void populate(Node node, Scanner sc) {
    System.out.println("Do you want to add to the left side of Node ?");
    boolean left = sc.nextBoolean();
    if (left) {
      System.out.println("Enter left node ");
      int val = sc.nextInt();
      System.out.println("value of left node " + val);
      node.left = new Node(val);
      populate(node.left, sc);
    }
    System.out.println("Do you want to add to the right side of Node ?");
    boolean right = sc.nextBoolean();
    if (right) {
      System.out.println("Enter right node ");
      int val = sc.nextInt();
      System.out.println("value of right node " + val);
      node.right = new Node(val);
      populate(node.right, sc);
    }
  }
}
