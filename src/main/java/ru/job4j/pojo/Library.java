package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book = new Book("Propety",200);
        Book book1 = new Book("Admission", 250);
        Book book2 = new Book("Revenge",300);
        Book cleanCode = new Book("CleanCode",1000);

        Book[] bookShelf = new Book[4];
        bookShelf[0] = book;
        bookShelf[1] = book1;
        bookShelf[2] = book2;
        bookShelf[3] = cleanCode;

        for (int index = 0; index < bookShelf.length; index++ ) {
            Book bookOutput = bookShelf[index];
            System.out.println(bookOutput.getName() + " " + bookOutput.getNumber());
        }

        System.out.println("Replace 0 to 3.");
        bookShelf[0] = cleanCode;
        bookShelf[3] = book;

        for (int index = 0; index < bookShelf.length; index++ ) {
            Book bookOutput = bookShelf[index];
            System.out.println(bookOutput.getName() + " " + bookOutput.getNumber());
        }

        for (int index = 0; index < bookShelf.length; index++ ) {
            Book bookOutput = bookShelf[index];
            if (bookOutput.getName().equals("CleanCode")) {
                System.out.println(bookOutput.getName() + " " + bookOutput.getNumber());
            }
        }
    }
}
