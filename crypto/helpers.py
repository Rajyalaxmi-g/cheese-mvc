def alphabet_position(letter):
    
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    letter = letter.lower()
    position = alphabet.index(letter) 
    return position

def rotate_character(char, rot):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    if char.isalpha():
        pos = alphabet_position(char)
        new_index = (pos + rot) % 26
        encrypted = alphabet[new_index]
        if char.isupper():
            encrypted = encrypted.upper()
        return encrypted
    else:
        return char