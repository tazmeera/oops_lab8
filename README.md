# OOP using Java - Lab Sheet 08 (MCA III Semester)

All 20 programs are in `src/`. Tested with JDK 21 (any JDK 8+ works; `new URL(String)` just prints a
deprecation warning on JDK 20+).

| Q | File(s) | What it shows |
|---|---|---|
| 1 | `StudentBean`, `Q01_StudentBeanDemo` | private id/name/grade with getters and setters |
| 2 | `RectangleBean`, `Q02_RectangleBeanDemo` | length, width, `calculateArea()`, `calculatePerimeter()` |
| 3 | `EmployeeBean`, `Q03_EmployeeBeanDemo` | Serializable bean; saved to a file and read back |
| 4 | `DateBean`, `Q04_DateBeanDemo` | read-only `currentDate` (getter only) |
| 5 | `UserBean`, `Q05_UserBeanDemo` | write-only `password` (setter only) |
| 6, 7 | `AccountBean`, `Q06_Q07_AccountBeanDemo` | bound property `balance`, PropertyChangeListener, events fired on update |
| 8 | `Q08_IntrospectorDemo` | Introspector lists properties and methods of StudentBean |
| 9 | `CarBean`, `Q09_CarBeanDemo` | make/model/year set and get |
| 10 | `CircleBean`, `Q10_CircleBeanDemo` | radius read/write; area and circumference read-only |
| 11 | `Q11_IpAddress` | host name and IP via InetAddress |
| 12, 13, 14 | `HelloServer`, `HelloClient` | TCP port 5000. Server prints "Client connected" (Q12), client sends "Hello Server" (Q13), server prints "Received from client: ..." (Q14 modified version) |
| 15 | `EchoServer` (+ `EchoClient` tester) | TCP port 5001, echoes each line back |
| 16, 17 | `MessageSender`, `MessageReceiver` | UDP port 6000, "Ping" |
| 18 | `WebReader` | reads http://example.com with a URL object (optional arg = other URL) |
| 19 | `FileDownloader` | downloads https://www.example.com/sample.txt with URLConnection (optional args: url, output file) |
| 20 | `MultiClientServer` (+ `MultiClientDemoClient` tester) | one thread per client, prints message with thread name, port 5002 |

## Compile
```
javac -d out src/*.java
```

## Run - bean programs (Q1-Q11)
`bash run_beans.sh` (or `cd out` then `java Q01_StudentBeanDemo`, etc.). Expected output: `expected_output_beans.txt`.

## Run - networking (open two terminals, `cd out` in both; start the SERVER first)
| Test | Terminal 1 | Terminal 2 |
|---|---|---|
| Q12-14 | `java HelloServer` | `java HelloClient` |
| Q15 | `java EchoServer` | `java EchoClient` |
| Q16-17 | `java MessageReceiver` | `java MessageSender` |
| Q20 | `java MultiClientServer` | `java MultiClientDemoClient 5` |
| Q18 | `java WebReader` | - |
| Q19 | `java FileDownloader` | - |

Expected results (as tested):
```
HelloServer : HelloServer listening on port 5000 ... / Client connected / Received from client: Hello Server
EchoServer  : Echoing: Hello / Echoing: Echo this back / Echoing: Bye / Client disconnected
Receiver    : Received: Ping  (from 127.0.0.1:<port>)
MultiClient : [Thread-0] Hello from client 4 ... one line per client, each with its own thread name
```
Ports must be free; if you see "Address already in use", stop the old server first.

## Notes
- Q18/Q19 need internet access. They were verified against a local web server (page printed, 39-byte file
  downloaded, 404 handled), but the real example.com URLs could not be reached from the environment where the code was
  written. Note that https://www.example.com/sample.txt probably does not exist, so a "HTTP 404" message from
  `FileDownloader` is the correct result for that exact address; try another URL to see a real download:
  `java FileDownloader https://www.gutenberg.org/robots.txt robots.txt`.
- `EchoClient` and `MultiClientDemoClient` are helper programs I added only to test the servers.
