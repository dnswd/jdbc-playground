# JDBC Playground

Playground to explore PostgreSQL's extended query features with JDBC.

### Run with [Nix](https://nixos.org/download/#nix-install-linux)

1. Start services with `nix run`
2. Run wireshark with scalated privilege `sudo wireshark` and listen to `any` interface with `pgsql` filter 
3. Run `Test.java` with `run-test`

### Run manually

1. Ensure PostgreSQL is running, replace the connection info in `Test.java` with yours
2. Ensure wireshark is installed and able to listen to `any` interface, filter with `pgsql`
3. Run `Test.java` with following script:

```sh
#!/usr/bin/env bash
javac -cp postgresql-42.6.0.jar Test.java
java -cp postgresql-42.6.0.jar:. Test
```
