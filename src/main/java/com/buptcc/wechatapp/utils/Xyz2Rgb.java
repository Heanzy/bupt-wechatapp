package com.buptcc.wechatapp.utils;

public class Xyz2Rgb {
    public static double[] XYZ2sRGB(double[] XYZ) {
        double [] sRGB = new double[3];
        double X, Y, Z;
        double dr, dg, db;
        X = XYZ[0];
        Y = XYZ[1];
        Z = XYZ[2];

        dr = 0.032406 * X - 0.015371 * Y - 0.0049895 * Z;
        dg = -0.0096891 * X + 0.018757 * Y + 0.00041914 * Z;
        db = 0.00055708 * X - 0.0020401 * Y + 0.01057 * Z;

        if (dr <= 0.00313) {
            dr = dr * 12.92;
        } else {
            dr = Math.exp(Math.log(dr) / 2.4) * 1.055 - 0.055;
        }

        if (dg <= 0.00313) {
            dg = dg * 12.92;
        } else {
            dg = Math.exp(Math.log(dg) / 2.4) * 1.055 - 0.055;
        }

        if (db <= 0.00313) {
            db = db * 12.92;
        } else {
            db = Math.exp(Math.log(db) / 2.4) * 1.055 - 0.055;
        }

        dr = dr * 255;
        dg = dg * 255;
        db = db * 255;

        dr = Math.min(255, dr);
        dg = Math.min(255, dg);
        db = Math.min(255, db);

        sRGB[0] = (int) (dr + 0.5);
        sRGB[1] = (int) (dg + 0.5);
        sRGB[2] = (int) (db + 0.5);

        return sRGB;
    }
}
