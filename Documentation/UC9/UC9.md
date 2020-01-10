# UC9 - List files and directories in working directory

As user I want to list all files and directories in working directory.

## Analysis

- User types `ls` to list all files and directories in working directory. System show a list of all files and directories with information (date from last update, permissions and type).

### Information format

```
date_last_update  permissions   type    name
10/01/2020 21:45  w-r-e         <DIR>   my__folder
(...)
```

- date_last_update: date and hour of last update to directory/file.
- permissions: options user is allow to do.
    - `w`: can write
    - `r`: can read
    - `e`: can excute
- type: \<DIR\> if is a folder or \<FILE\> if is a file.
- name: name of directory/file.
