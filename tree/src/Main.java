import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    Scanner scanner = new Scanner(System.in);
    tree.populate(scanner);

    System.out.println("preOrderTraversalIteratively");
    tree.preOrderTraversalIteratively();
    System.out.println("\npreOrder");
    tree.preOrder();
    System.out.println("\ninOrderTraversalIteratively");
    tree.inOrderTraversalIteratively();
    System.out.println("\ninOrder");
    tree.inOrder();
    System.out.println("\npostOrderTraversalIteratively");
    tree.postOrderTraversalIteratively();
    System.out.println("\npostOrderUsingOneStack");
    tree.postOrderUsingOneStack();
    System.out.println("\npostOrder");
    tree.postOrder();
    System.out.println("\nlevelOrderTraversal");
    tree.levelOrderTraversal();
  }
}
