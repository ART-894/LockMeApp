package LockedME;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Lock {
	static String fileDirectory = "F:\\CameraReport\\BatchReport";

	public static void main(String[] args) {
		developerDetails();
		displayMainMenu();

		short option = 0, fileop = 0;

		check: while (true) {
			Scanner scanOption = new Scanner(System.in);
			option = scanOption.nextShort();
			switch (option) {

			case 1:
				File file = new File(fileDirectory);
				String[] files = file.list();
				System.out.println("\n---------------------------------------");
				System.out.println("Displaying the files and directories from a directory");
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i]);
				}
				System.out.println("---------------------------------------");
				System.out.print("Please choose another option to continue : ");

				break;
			case 2:
				fileOptionMenu();
				fileCheck: while (true) {
					Scanner scanFile = new Scanner(System.in);
					fileop = scanFile.nextShort();
					switch (fileop) {
					case 1:
						System.out.println("\n---------------------------------------");
						System.out.println("Adding contents into file and saving into directory");
						try {
							Scanner fileCreate = new Scanner(System.in);
							System.out.print("Please enter the filename to be created : ");
							String name = fileCreate.nextLine();
							File fileCheck = new File(fileDirectory + name);
							if (fileCheck.exists()) {
								System.out.println("File already exists");
							} else {
								FileWriter fw = new FileWriter(fileDirectory + name);
								System.out.print("Please enter the file content : ");
								String content = fileCreate.nextLine() + "\n";
								fw.write(content);
								fw.close();
								System.out.println("File created with a name : " + name);
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("---------------------------------------");
						System.out.print("Please choose another option to continue : ");
						break;
					case 2:
						System.out.println("\n---------------------------------------");
						System.out.println("Deleting a file from directory");
						Scanner af = new Scanner(System.in);
						System.out.print("Please enter the filename to be deleted : ");
						String deletename = af.nextLine();
						File fd = new File(fileDirectory + deletename);
						if (fd.exists()) {
							if (fd.delete()) {
								System.out.println("File deleted successfully");
							} else {
								System.out.println("Failed to delete the file");
							}
						} else {
							System.out.println("File does not exist in directory");
						}
						System.out.println("---------------------------------------");
						System.out.print("Please choose another option to continue : ");
						break;
					case 3:
						System.out.println("\n---------------------------------------");
						System.out.println("Searching a file in the directory");
						try {
							File filesearch = new File(fileDirectory);
							String[] search = filesearch.list();
							System.out.print("Please enter filename to search : ");
							Scanner fs = new Scanner(System.in);
							String fileSearch = fs.nextLine();
							int flag = 0;
							if (search == null)
								System.out.println("Empty directory");
							else {
								for (int i = 0; i < search.length; i++) {
									String filename = search[i];
									if (filename.equals(fileSearch)) {
										System.out.println("File found : " + filename);
										flag = 1;
									}
								}
							}
							if (flag == 0)
								System.out.println("File not found : " + fileSearch);
						}

						catch (NullPointerException ex) {
							System.out.println("Please specify the correct folder name");
						}
						System.out.println("---------------------------------------");
						System.out.print("Please choose another option to continue : ");
						break;
					case 4:
						displayMainMenu();
						break fileCheck;
					default:
						System.out.print("Please select a number from above list : ");
					}

				}
				break;
			case 3:
				System.out.println("\n---------------------------------------");
				System.out.println("Set Directory:");
				System.out.println("---------------------------------------");
				Scanner scanFile = new Scanner(System.in);
				System.out.print("Please Enter the Directory Location : ");
				String diroperation = scanFile.nextLine();
				File dir = new File(diroperation);
				if (dir.isDirectory()) {
					fileDirectory = diroperation;
					System.out.println("Directory is Set");

				} else {
					System.out.println("Please specify the Correct Directory Name");
				}
				System.out.println("---------------------------------------");
				System.out.print("Please choose another option to continue : ");
				break;
			case 4:
				System.out.println("\n---------------------------------------");
				System.out.println("Program Closed by User");
				System.out.println("---------------------------------------");
				break check;
			default:
				System.out.print("Please select a number from above list : ");
			}
		}
	}

	public static void displayMainMenu() {
		System.out.println("---------------------------------------");
		System.out.println("\n\nUser File Functions");
		System.out.println("---------------------------------------");
		System.out.println("1) Display File List");
		System.out.println("2) File Operations");
		System.out.println("3) Set Directory");
		System.out.println("4) Close the Application");
		System.out.println("---------------------------------------");
		System.out.print("\nPlease choose an option from above : ");

	}

	public static void fileOptionMenu() {
		System.out.println("\n---------------------------------------");
		System.out.println("1) Add a file to directory");
		System.out.println("2) Delete a file from directory");
		System.out.println("3) Search a file from directory");
		System.out.println("4) Back to Main Menu");
		System.out.println("---------------------------------------");
		System.out.print("\nPlease choose an option from above : ");

	}

	public static void developerDetails() {
		System.out.println("---------------------------------------");
		System.out.println("Application : LockedMe.com");
		System.out.println("---------------------------------------");
		System.out.println("Developer Details");
		System.out.println("---------------------------------------");
		System.out.println("Name        : Abhinav Tiwari");
		System.out.println("Email       : abhiT@Tech.com");
		System.out.println("Designation : Developer");

	}

}