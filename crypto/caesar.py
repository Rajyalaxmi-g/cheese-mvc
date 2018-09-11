from helpers import alphabet_position, rotate_character

def encrypt(text,rot):
    encrypted = ""
    for ch in text:
        encrypted += rotate_character(ch,rot)
    return encrypted
def main():
    text = input("Type a message:")
    rot = int(input("Rotate by:"))
    print(encrypt(text,rot))

if __name__ == "__main__":
    main()

