/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocloseable;

/**
 *
 * @author c3
 */
public class Abc implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("closing Abc");
    }

    public Abc() {
        System.out.println("creating abc"
        );
    }

}
