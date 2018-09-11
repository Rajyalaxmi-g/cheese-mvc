def get_initials(fullname):
    # some code here
    split_string = fullname.split(" ")
    init = ""
    for s in split_string:
        initial = s[0]
        init = init + initial
    return init.upper()
def main():   
   print(get_initials("Ozzie Smith"))
          
if __name__ == "__main__":
    main()