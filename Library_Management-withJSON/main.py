import json

books = []
def load_books():
    with open("books.json", "r") as file:
        data = json.load(file)
        return data["books"]

def load_borrowed_books():
    with open("books.json", "r") as file:
        data = json.load(file)
        return data["borrowed_books"]

books = load_books()

def save_books():
    with open("books.json", "w") as file:
        json.dump({
            "books": books,
            "borrowed_books": borrowed_books
        }, file, indent=4)
        
borrowed_books = []

def show_menu(): 
    print("---MENU----") 
    print("1. Add book") 
    print("2. View book") 
    print("3. Search book") 
    print("4. delete book") 
    print("5. borrow book") 
    print("6. Return book") 
    print("7. Exit") 
    print("Seeing the menu enter choice number alone") 
    
def user_choice(): 
    try: 
        choice = int(input("Enter your choice : ")) 
        return choice 
    except ValueError: 
        print("Invalid, please enter number") 
        return None 

while True:     
 show_menu() 
 choice = user_choice()
 if choice == 1: 
    print("---adding book---") 
    book_name = input("Enter book name:")
    books.append(book_name)
    save_books()
    print("Added successfully!!")
 elif choice == 2: 
    print("----view of the books----") 
    print(books)
 elif choice == 3: 
    print("---Searching book----")
    search_book = input("Enter the book to search:")
    if search_book in books:
        print("Book found !")
    else:
        print("Book is not available")
 elif choice == 4: 
    print("----Deleting book----") 
    del_book = input("Enter the book to delete:")
    if del_book in books:
        books.remove(del_book)
        save_books()
        print("Book is deleted successfully!!")
    else:
        print("the book you want to delete is not available !!")
 elif choice == 5: 
    print("----Borrowing book-----") 
    borrow = input("Enter the book to borrow :")
    if borrow in books:
       books.remove(borrow)
       borrowed_books.append(borrow)
       save_books()
       print("Sccessfully borrowed!")
    else:
       print("The book u asked is not available")
 elif choice == 6: 
    print("-----returning book-----") 
    retbook = input("Enter the book to return:")
    if retbook in borrowed_books:
       borrowed_books.remove(retbook)
       books.append(retbook)
       save_books()
       print("The book returned sccessfully!!")
    else:
       print("The book u mentioned is not available")
 elif choice == 7: 
    print("Exit") 
    break
 else: 
    print("Invalid ! enter correct number") 
