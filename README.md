# Substitution Cipher

1. Encrypt the message
2. Encrypt the message using key
3. Decrypt the message using key
<!-- 2. Decrypt the message (Preparing..) -->

> This program provides the values in { .. }.
> Since this program is based on a substitution cipher, it only supports English.

<br />

## 1. Encrypt the message

Make a key and encrypt the `message`.

    {encrypted message}
    (Key: {key})

- `message` : message (plain text before it's encrypted)

<br />

## 2. Encrypt the message using key

Encrypt the `message` using `key`.

    {encrypted message}

- `key` : key (Must consist of 26 different alphabets (Length: 26))
- `message` : message (plain text before it's encrypted)

<br />

## 3. Decrypt the message using key

Decrypt the `message` using `key`.

    {decrypted message}

- `key` : key (Must consist of 26 different alphabets (Length: 26))
- `message` : message (cipher text after it's encrypted)

<br />

# Usage

```Bash
# java version: openjdk 11.0.11
cd bin
java App [FLAG]
```

### Kind of FLAG
- `-e <message>` : Encrypt the message
- `-e-key <key> <message>` : Encrypt the message using key
- `-d-key <key> <message>` : Decrypt the message using key
- `-help` : How to use it
<!-- - `-d <message>` : Decrypt the message -->

### Example
```Bash
# Encrypt the message
>> java App -e "apple"
illzb
(Key: ijngbweadykzthplvxsrmcfouq)

# Encrypt the message using key
>> java App -e-key ijngbweadykzthplvxsrmcfouq "apple"
illzb

# Decrypt the message using key
>> java App -d-key ijngbweadykzthplvxsrmcfouq "illzb"
apple
```
