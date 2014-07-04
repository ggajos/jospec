package com.opentangerine.jospec.scanner;

import com.opentangerine.jospec.Jospec;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScannerTest {

    @Test
    public void shouldFoundAtLeastOneModuleInJoSpecModule() {
        assertFalse(Scanner.scan("com.opentangerine.jospec").getSpecs().isEmpty());
    }

    @Test
    public void shouldNotFoundAnyModuleIfPackageNotExists() {
        assertTrue(Scanner.scan("com.opentangerine.jospec.notexistingpackage").getSpecs().isEmpty());
    }

}