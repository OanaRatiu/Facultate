import random
import string


def isprime(n):
    """check if integer n is a prime"""
    for x in xrange(2, int(n**0.5)+1):
        if n % x == 0:
            return False
    return True


def generate_key(p, g):
    # choose randmly a, the secret key
    a = random.randint(3, p-2)
    # compute g^a mod p, which is the public key
    public_key = (g ** a) % p
    return (public_key, a)


def encrypt_letter(index, bob_public_key, alice_secret_key, p):
    return (index * (bob_public_key ** alice_secret_key)) % p


def decrypt_letter(index, alice_public_key, bob_secret_key, p, K):
    for i in range(2, p):
        if index == i * K % p:
            return i
    return None


def compute_K(alice_public_key, bob_secret_key, p):
    return (alice_public_key ** bob_secret_key) % p


def validate_message(message, alphabet):
    for letter in message:
        if letter not in alphabet.keys():
            print "Message is not valid! It does not contain only letters/_."
            return False
    print "Message is valid!"
    return True


if __name__ == '__main__':
    alphabet = list(string.ascii_lowercase)
    alphabet = {letter: i for i, letter in enumerate(alphabet)}
    alphabet[" "] = len(alphabet.keys())
    # make inversed alhpabet because we need it for decryption
    # decrypt will return the indexes of the ltters in the alphabet
    inversed_alphabet = {value: key for key, value in alphabet.items()}

    # select prime p and g
    # p > nb of letters in the alphabet
    p = random.randint(len(alphabet), 3000)
    while not isprime(p):
        p = random.randint(len(alphabet), 3000)
    g = 8

    # generate the public and secret keys for bot alice and bob
    alice_public_key, alice_secret_key = generate_key(p, g)
    bob_public_key, bob_secret_key = generate_key(p, g)
    message = "now"

    # text validation
    if validate_message(message, alphabet):
        # compute K, which is always the same - used for decryption
        K = compute_K(alice_public_key, bob_secret_key, p)
        decrypted_message = ''
        for letter in message:
            c = encrypt_letter(
                alphabet[letter], bob_public_key, alice_secret_key, p)
            decrypted_message += inversed_alphabet[decrypt_letter(
                c, alice_public_key, bob_secret_key, p, K)]
        print message + " -> " + decrypted_message
