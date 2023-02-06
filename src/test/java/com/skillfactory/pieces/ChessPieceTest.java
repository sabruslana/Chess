package com.skillfactory.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

class ChessPieceTest {

    @Test
    public void chessPieceClassTest() {
        boolean check = Modifier.isAbstract(ChessPiece.class.getModifiers()) && ChessPiece.class.getConstructors().length > 0;

        Field[] fields = ChessPiece.class.getDeclaredFields();
        Method[] methods = ChessPiece.class.getDeclaredMethods();

        Map<String, String> fDict = new HashMap<>();
        Map<String, String> mDict = new HashMap<>();

        for (Field field : fields) {
            fDict.put(field.getName(), field.getType().getName());
        }

        for (Method method : methods) {
            if (method.getName().equals("getColor") || method.getName().equals("canMoveToPosition") ||
                    method.getName().equals("getSymbol")) {
                if (!Modifier.isAbstract(method.getModifiers())) check = false;
            }
            mDict.put(method.getName(), method.getReturnType().getName());
        }

        check = check && fDict.containsKey("color") && fDict.containsKey("check") && mDict.containsKey("getColor") &&
                mDict.containsKey("canMoveToPosition") && mDict.containsKey("getSymbol");

        if (check) check = fDict.get("color").equals("java.lang.String") && fDict.get("check").equals("boolean") &&
                mDict.get("getColor").equals("java.lang.String") && mDict.get("getSymbol").equals("java.lang.String") &&
                mDict.get("canMoveToPosition").equals("boolean");


        Assertions.assertTrue(check, "The ChessPiece class is incorrect");
    }
}
