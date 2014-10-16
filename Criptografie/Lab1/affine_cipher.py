import Tkinter
import tkMessageBox
import ttk

class AffineCypher(object):
    def __init__(self):
        self.alphabet = {chr(i+65): i for i in range(26)}
        self.alphabet['.'], self.alphabet['?'], self.alphabet['!'] = 26, 27, 28
        self.a, self.b = 3, 11
        self.ecnrypted_alphabet = {}
        self.len = len(self.alphabet)

    def set_alphabet(self, alphabet):
        self.alphabet = {alphabet[i]: i for i in range(len(alphabet))}
        self.len = len(alphabet)

    def encrypt(self):
        self.validate()
        ecnrypted_alphabet = {}
        for key, value in self.alphabet.items():
            ecnrypted_alphabet[key] = (self.a * value + self.b) % self.len
        return ecnrypted_alphabet

    def affine_word(self, text):
        ciphertext = ''
        for letter in text:
            ciphertext += [key for key, value in self.alphabet.items() 
                if value == self.ecnrypted_alphabet[letter]][0]
        return ciphertext

    def decrypt(self, ciphertext):
        dechyper = ''
        for i in range(self.len):
            if (self.a * i) % self.len == 1:
                break
        for j in range(self.len):
            if (self.b + j) % self.len == 0:
                break
        # we will work by the formula (letter + j) * i mod(self.len), y = a*x + b
        for letter in ciphertext:
            value_to_be_decr = ((((self.alphabet[letter] + j) % self.len ) * i) % self.len)
            dechyper += [key for key, value in self.alphabet.items() 
                 if value == value_to_be_decr][0]
        return dechyper

    def validate_numbers(self):
        if type(self.a) is not int or type(self.b) is not int:
            return False
        if self.a not in range(self.len) or self.b not in range(self.len):
            return False
        return True

    def validate_alphabet(self):
        for letter in self.alphabet:
            if letter.islower():
                return False
        return True

    def validate(self):
        if not self.validate_numbers():
            raise ValueError('NUMBERS NEED TO BE GREATER THAN 0 AND LESS THAN ' + str(self.len))
        if not self.validate_alphabet():
            raise ValueError('ALPHABET IS NOT VALID. There are lower case letters!')


class simpleapp_tk(Tkinter.Tk):
    def __init__(self, parent):
        Tkinter.Tk.__init__(self,parent)
        self.parent = parent
        self.initialize()
        self.affine_cypher = AffineCypher()

    def initialize(self):
        self.grid()

        # alphabet label
        self.label_alphabet = Tkinter.Label(self, anchor="w", fg='black', text="Alphabet: ")
        self.label_alphabet.grid(column=0, row=0, sticky='EW')
        # alphabet entry
        self.entry_alphabet = Tkinter.StringVar()
        self.entry_key = Tkinter.Entry(self, textvariable=self.entry_alphabet)
        self.entry_key.config(width=30)
        self.entry_key.grid(column=1,row=0,sticky='NE')

        # m label
        self.label_m = Tkinter.Label(self, anchor="w", fg='black', text="Give m: ")
        self.label_m.grid(column=0, row=1, sticky='EW')
        # m entry
        self.entry_m = Tkinter.StringVar()
        self.entry_key = Tkinter.Entry(self, textvariable=self.entry_m)
        self.entry_key.config(width=30)
        self.entry_key.grid(column=1,row=1,sticky='NE')


        # b label
        self.label_b = Tkinter.Label(self, anchor="w", fg='black', text="Give b: ")
        self.label_b.grid(column=0, row=2, sticky='EW')
        # b entry
        self.entry_b = Tkinter.StringVar()
        self.entry_key = Tkinter.Entry(self, textvariable=self.entry_b)
        self.entry_key.config(width=30)
        self.entry_key.grid(column=1,row=2,sticky='NE')

        # TEXT label
        self.text_label = Tkinter.Label(self, anchor="w", fg="black", text="Text")
        self.text_label.grid(column=0, row=3, sticky="EW")


        # TEXT to encrypt entry
        self.entry_text = Tkinter.Entry(self)
        self.entry_text.config(width=30)
        self.entry_text.grid(column=1, row=3, sticky='ne')


        self.separator = ttk.Separator(self, orient=Tkinter.HORIZONTAL)
        self.separator.grid(columnspan=2, row=4, sticky="ew")  


        #  =============== ENCRYPTION ===============
        # CYPHERTEXT label
        self.cyphertext_label = Tkinter.Label(self, anchor='w', fg='black', text='Cyphertext')
        self.cyphertext_label.grid(column=0, row=5, sticky='ew') 

        # CCYPHERTEXT entry
        self.entry_cyphertext_str = Tkinter.StringVar()
        self.entry_cyphertext = Tkinter.Entry(self, textvariable=self.entry_cyphertext_str)
        self.entry_cyphertext.grid(column=1, row=5, sticky='ne')
        self.entry_cyphertext.config(width=30)

        # ENCRYPT button
        self.encrypt_button = Tkinter.Button(self, text=u'Encrypt', command=self._OnEncryptButtonClick)
        self.encrypt_button.grid(column=1, row=6, sticky='ne')


        self.separator = ttk.Separator(self, orient=Tkinter.HORIZONTAL)
        self.separator.grid(columnspan=2, row=7, sticky="ew")   


        #============== DECRYPTION ===============

        # DECRYPTED label
        self.decrypted_label = Tkinter.Label(self, anchor='w', fg='black', text='Decrypted')
        self.decrypted_label.grid(column=0, row=8, sticky='w')

        # DECRYPTED entry
        self.decrypted_entry_str = Tkinter.StringVar()
        self.decrypted_entry = Tkinter.Entry(self, textvariable=self.decrypted_entry_str)
        self.decrypted_entry.grid(column=1, row=8, sticky='ne')
        self.decrypted_entry.config(width=30)

        # DECRYPT button
        self.encrypt_button = Tkinter.Button(self, text=u'Decrypt', command=self._OnDecryptButtonClick)
        self.encrypt_button.grid(column=1, row=9, sticky='ne')


        self.grid_columnconfigure(1, weight=1)

    def _OnEncryptButtonClick(self):
        try:
            if self.entry_alphabet.get():
                self.affine_cypher.set_alphabet(self.entry_alphabet.get())
            self.affine_cypher.a = int(self.entry_m.get())
            self.affine_cypher.b = int(self.entry_b.get())
            self.affine_cypher.ecnrypted_alphabet = self.affine_cypher.encrypt()
        except ValueError as e:
            tkMessageBox.showinfo(e.message)
            return

        self.entry_cyphertext_str.set(self.affine_cypher.affine_word(self.entry_text.get()))

    def _OnDecryptButtonClick(self):
        try:
            if self.entry_alphabet.get():
                self.affine_cypher.set_alphabet(self.entry_alphabet.get())
            self.affine_cypher.a = int(self.entry_m.get())
            self.affine_cypher.b = int(self.entry_b.get())
            self.affine_cypher.ecnrypted_alphabet = self.affine_cypher.encrypt()
        except ValueError as e:
            tkMessageBox.showinfo(e.message)
            return
        self.decrypted_entry_str.set(self.affine_cypher.decrypt(self.entry_text.get()))



if __name__ == "__main__":
    app = simpleapp_tk(None)
    app.title('Affine Cypher')
    app.mainloop()