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
public class DemoAuto {

    public static void main(String[] args) throws Exception {
        try (Abc a = new Abc(); Xyz x = new Xyz()) {

        } catch (Exception e) {
            System.out.println("Exception Foundd");
            throw new Exception("dfghj");
        }

    }
}
