package utils;

import java.util.Arrays;
import java.util.Random;

public class OTP {

    private static long lastTime;
    private static long now;

    private static String code;

    public static void generate(String email) {
        lastTime = System.currentTimeMillis();
        // Tạo một đối tượng Random
        Random random = new Random();

        // Random 1 số có 5 con số ngẫu nhiên
        int[] randomNumbers = random.ints(1, 101).limit(5).toArray();

        // Nối các số ngẫu nhiên lại với nhau
        String randomNumber = String.join("", Arrays.stream(randomNumbers).mapToObj(String::valueOf).toArray(String[]::new));
        code = randomNumber.substring(0, 5);
        Email.sendOTP(email, "Xác minh tài khoản", "Mã xác nhận của bạn là: " + code);
    }

    public static boolean verification(String otp) {
        now = System.currentTimeMillis();
        if (now - lastTime >= 10 * 60 * 1000) {
            return false;
        } else {
            return code.equals(otp);
        }
    }
}
