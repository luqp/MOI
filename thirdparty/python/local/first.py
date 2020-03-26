import second

def show_greeting():

    gr = second.Greetings()
    name = input("Enter your name > ")
    gr.write_greeting(name)

if __name__ == "__main__":
    show_greeting()
