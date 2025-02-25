package es.uclm.esi.multimedia.utilities;

/**
 * Created by Ruth on 30/11/2017.
 */

public class Complex {

    private final double re; // The real part
    private final double im; // The imaginary part

    // Create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // Return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) {
            return re + "";
        }
        if (re == 0) {
            return im + "i";
        }
        if (im < 0) {
            return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }

    // Return abs/modulus/magnitude and angle/phase/argument
    public double abs() {
        return Math.hypot(re, im);
    } // Math.sqrt(re*re + im*im)

    public double phase() {
        return Math.atan2(im, re);
    } // Between -pi and pi

    // Return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this; // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // Return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // Return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // Scalar multiplication
    // Return a new object whose value is (this * alpha)
    public Complex times(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // Return a new Complex object whose value is the conjugate of this
    public Complex conjugate() {
        return new Complex(re, -im);
    }

    // Return a new Complex object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    // Return the real or imaginary part
    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    // Return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // Return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re)
                * Math.sin(im));
    }

    // Return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re)
                * Math.sinh(im));
    }

    // Return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re)
                * Math.sinh(im));
    }

    // Return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }

    // A static version of plus
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }
}
