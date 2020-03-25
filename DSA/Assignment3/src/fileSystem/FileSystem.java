package fileSystem;

import java.util.Scanner;

/**
 * Class to implement a File System
 *
 */
public class FileSystem {
	private Folder root;
	private Folder pwd;

	/**
	 * Constructor to initialize the file system
	 * @throws Exception
	 */
	public FileSystem() throws Exception {
		this.root = new Folder("R:");
		this.pwd = this.root;
	}
	
	/**
	 * Function to display present working directory
	 */
	public void displayPresentWorkingDirectory(){
		System.out.print(this.pwd.getPath()+"> ");
	}
	
	/**
	 * Function to add folder to present working directory
	 * @param folderName of new folder
	 * @throws Exception
	 */
	public void addFolder(String folderName) throws Exception {
		this.pwd.addFolder(folderName);
	}
	
	/**
	 * Function to change present working directory
	 * @param folderName
	 */
	public void changeDirectory(String folderName) {
		Folder folder = this.pwd.findFolder(folderName);
		if(folder == null) {
			System.out.println("Folder" + folderName + " not found!\n");
		} else {
			this.pwd = folder;
			System.out.println();
		}
	}
	
	/**
	 * Function to move present working directory to parent
	 */
	public void moveToParent() {
		Folder parent = this.pwd.getParent();
		if(parent == null) {
			System.out.println("pwd is currently at top level!\n");
		} else {
			this.pwd = parent;
			System.out.println();
		}
	}
	
	/**
	 * Function to list sub directories details
	 * @param folderName
	 */
	public void listSubDirectories(String folderName) {
		if(folderName == null){
			this.pwd.listSubDirectories();
		} else {
			Folder folder = this.pwd.findFolder(folderName);
			if(folder == null){
				System.out.println("Folder " + folderName + " not found!");
			} else {
				folder.listSubDirectories();
			}
		}
	}
	
	/**
	 * Function to print tree structure of whole file system
	 */
	public void printTree(){
		this.root.printTree(0);
		System.out.println();
	}
	
	/**
	 * Function to find folder by name recursively
	 * @param name to search
	 * @throws Exception
	 */
	public void findFolder(String name) throws Exception {
		this.pwd.findFolderRecursively(name);
	}
	
	/**
	 * Main function to implement command line
	 * @param args
	 */
	public static void main(String args[]){
		try{
			Scanner scanner = new Scanner(System.in);
			FileSystem fileSystem = new FileSystem();
			boolean flag = true;
			
			while(flag) {
				fileSystem.displayPresentWorkingDirectory();
				String command = scanner.nextLine();
				String[] tokens = command.split(" ");
				
				switch(tokens[0]) {
				case "mkdir":
					if(tokens.length != 2 || tokens[1].length() == 0){
						printInvalidSyntexMessage();
					} else {
						fileSystem.addFolder(tokens[1]);
					}
					break;
				case "cd":
					if(tokens.length != 2 || tokens[1].length() == 0){
						printInvalidSyntexMessage();
					} else {
						fileSystem.changeDirectory(tokens[1]);
					}
					break;
				case "bk":
					if(tokens.length != 1){
						printInvalidSyntexMessage();
					} else {
						fileSystem.moveToParent();
					}
					break;
				case "ls":
					if(tokens.length > 2 || (tokens.length ==2 && tokens[1].length() == 0)){
						printInvalidSyntexMessage();
					} else if(tokens.length == 1) {
						fileSystem.listSubDirectories(null);
					} else {
						fileSystem.listSubDirectories(tokens[1]);
					}
					break;
				case "exit":
					flag = false;
					break;
				case "find":
					if(tokens.length != 2 || tokens[1].length() == 0){
						printInvalidSyntexMessage();
					} else {
						fileSystem.findFolder(tokens[1]);
						System.out.println();
					}
					break;
				case "tree":
					if(tokens.length != 1){
						printInvalidSyntexMessage();
					} else {
						fileSystem.printTree();
					}
					break;
				default:
					System.out.println(tokens[0] + " is not recognised as a command!\n");
				}
			}
			
			scanner.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Function to print invalid syntax message
	 */
	private static void printInvalidSyntexMessage(){
		System.out.println("The syntex of the command is incorrent!\n");
	}
}
