///XO Class of XO Game
///Created By Thanawat Chuensriwirot 60160078
///Burapha University

public class XO {
    private char who_win = 'N';
    private boolean win = false;
    private char status = 'x';
    private boolean error = false;

    private char[][] mipmap =  new char[][]{{'*','*','*'},
            {'*','*','*'},
            {'*','*','*'}};

    private char[][] mipmap_backup =  new char[][]{{'*','*','*'},
            {'*','*','*'},
            {'*','*','*'}};


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public char isWho_win() {
        return who_win;
    }

    public char getStatus(){
        return status;
    }

    public void showMipmap() {
        for(char[] k:mipmap){
            System.out.println(k);
        }
    }

    public char[][] getMipmap() {
        return mipmap;
    }



    public void setStatus(char status) {
        this.status = status;
    }

    public void setWho_win(char who_win) {
        this.who_win = who_win;
    }

    public void check_win(){
        /*
         *           |*--|
         *           |-*-|
         *           |--*|
         * */
        if(mipmap[0][0]=='x'&&mipmap[1][1]=='x'&&mipmap[2][2]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[0][0]=='o'&&mipmap[1][1]=='o'&&mipmap[2][2]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |--*|
         *           |-*-|
         *           |*--|
         * */
        if(mipmap[0][2]=='x'&&mipmap[1][1]=='x'&&mipmap[2][0]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[0][2]=='o'&&mipmap[1][1]=='o'&&mipmap[2][0]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |***|
         *           |---|
         *           |---|
         * */
        if(mipmap[0][0]=='x'&&mipmap[0][1]=='x'&&mipmap[0][2]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[0][0]=='o'&&mipmap[0][1]=='o'&&mipmap[0][2]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |---|
         *           |***|
         *           |---|
         * */
        if(mipmap[1][0]=='x'&&mipmap[1][1]=='x'&&mipmap[1][2]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[1][0]=='o'&&mipmap[1][1]=='o'&&mipmap[1][2]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |---|
         *           |---|
         *           |***|
         * */
        if(mipmap[2][0]=='x'&&mipmap[2][1]=='x'&&mipmap[2][2]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[2][0]=='o'&&mipmap[2][1]=='o'&&mipmap[2][2]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |*--|
         *           |*--|
         *           |*--|
         * */
        if(mipmap[0][0]=='x'&&mipmap[1][0]=='x'&&mipmap[2][0]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[0][0]=='o'&&mipmap[1][0]=='o'&&mipmap[2][0]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |-*-|
         *           |-*-|
         *           |-*-|
         * */
        if(mipmap[0][1]=='x'&&mipmap[1][1]=='x'&&mipmap[2][1]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[0][1]=='o'&&mipmap[1][1]=='o'&&mipmap[2][1]=='o'){
            setWho_win('o');
            setWin(true);
        }
        /*
         *           |--*|
         *           |--*|
         *           |--*|
         * */
        if(mipmap[0][2]=='x'&&mipmap[1][2]=='x'&&mipmap[2][2]=='x'){
            setWho_win('x');
            setWin(true);
        }else if(mipmap[0][2]=='o'&&mipmap[1][2]=='o'&&mipmap[2][2]=='o'){
            setWho_win('o');
            setWin(true);
        }
    }
}