package com.twu.biblioteca;

import com.twu.biblioteca.Shell.BibliotecaShell;

/**
 * Created by pyan on 8/1/16.
 */
public class BibliotecaProgram {
        public static void main(String[] args) {
            new BibliotecaShell(System.out, System.in).Execute();
        }
}
