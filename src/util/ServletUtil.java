package util;

public final class ServletUtil  {
    private static final String PREFIX="/WEB-INF/jsp/";
    private static final String SUFFIX=".jsp";
    private static final String GAME_FILE_PREFIX ="D:\\work\\TorrentFiles\\" ;
    private static final String GAME_FILE_SUFFIX =".torrent" ;

    private ServletUtil(){}
    public static String createViewPath(String viewName){
        return String.format("%s%s%s",PREFIX,viewName,SUFFIX);
    }
    public static String createFileName(String name){return String.format("%s%s",name, GAME_FILE_SUFFIX);}
    }



