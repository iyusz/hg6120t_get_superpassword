public class get_superpassword {
    public static void main(String[] args) {
        //`telnet 192.168.1.1`，并使用账号`root`和密码`abcd`
        Map<String, String> map = new HashMap<>();
        //  获取信息的方式 http://192.168.1.1:8080/cgi-bin/baseinfoSet.cgi
        // fixme,下面两行把从路由器拿到的信息放在这里
        map.put("telecomadmin", "121&84&53&65&89&53&71&99&101&82&");
        map.put("useradmin", "121&84&53&65&89&53&71&99&101&82&");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            String[] split = entry.getValue().split("&");
            for (String s : split) {
                int offset = 4;
                if ((Integer.parseInt(s) >=66 && Integer.parseInt(s)<=90 )||(Integer.parseInt(s) >=101 && Integer.parseInt(s)<=122)){
                    stringBuilder.append((char) (Integer.parseInt(s) - 4));
                }else if ((Integer.parseInt(s) >=65 && Integer.parseInt(s)<=68 )||(Integer.parseInt(s) >=97 && Integer.parseInt(s)<=100)){
                    stringBuilder.append((char) (Integer.parseInt(s) + 22));
                }
            }
            map.put(entry.getKey(), stringBuilder.toString());
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
