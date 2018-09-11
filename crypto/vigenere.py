from helpers import alphabet_position, rotate_character

def encrypt(text,key):
    encrypted = []
    count = 0
    for char in text:
        key_pos = alphabet_position(key[count])
        var = rotate_character(char,key_pos)
        encrypted.append(var)
        if char.isalpha():
            count = count + 1
        if count > len(key) - 1:
            count = 0
    encrypted_str = ''.join(encrypted)
        
    return encrypted_str
def main():
    msg = input("Type a message:")
    key = input("Encryption key:")
    print(encrypt(msg,key))
    
if __name__ == "__main__":
    main()    