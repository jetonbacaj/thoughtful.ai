

# Requirements:
- JDK 1.8 or greater (latest OpenJDK version highly recommended!)

# To run the unit tests:
- Go to the root directory of the project in your terminal (Linux/MacOS, or Windows WSL)
- Execute `sbt` in the above directory 
- Once all of the dependencies have been downloaded and the project compiled, you should be presented with the following prompt: `sbt:thoughtful.ai>`
- Execute `test` at the above prompt
- You should see the following: 
``` 
sbt:thoughtful.ai> test
MyPackageSortSuite:
  + Test happy path => STANDARD 0.007s
  + Test SPECIAL for input width=150 0.0s
  + Test SPECIAL for input height=150 0.001s
  + Test SPECIAL for input length=150 0.0s
  + Test SPECIAL for input mass=21 0.0s
  + Test REJECTED for input width=150, mass=21 0.0s
  + Test REJECTED for input height=150, mass=21 0.001s
  + Test REJECTED for input length=150, mass=21 0.0s
  + Test ERROR for input mass=-1 0.0s
  + Test ERROR for input width=0 0.001s
  + Test ERROR for input height=0 0.0s
  + Test ERROR for input length=0 0.0s
[info] Passed: Total 12, Failed 0, Errors 0, Passed 12
[success] Total time: 0 s, ...
```

If you want to add other test cases, follow the template of the current tests in `MyPackageSortSuite`, and just change the input on the `sort` call