#Interpreter - module

## Contributing - Branching
We decided to use the **MAINLINE INTEGRATION PATTERN**. 
It's based on one single main thread, from which all new functionalities, bug 
fixes or anything should be based on.

This main branch will be the production branch. Every push to it will end in a published change.
We've chosen this pattern to simplify integration, as the functionality is certainly limited, it
should not have many changes beside any particular bug fix.

1. The first step is to clone this repository to your local machine, and add a new branch **from main**. 
 Work within this new branch.
2. Commit locally, run all tests in order to prove everything is still working and add yours to prove
 your functionality is working correctly.
3. Be as descriptive as possible when writing tests and comment to explain as much as you can.
4. When you think your work is done and ready to be merged to the main branch, please create a new 
**Merge request**. In the description of it, please be as descriptive as possible to resume what's 
your work about. It's imperative to have previously updated your branch with lastest main version. Otherwise 
your request will be not taken into account.
5. One of our maintainers will check your code and let you know if anything is missing.
6. Once the merge request has been accepted, your branch will be merged to main and deleted to maintain order
