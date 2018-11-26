//package fall2018.csc2017.GameCentre;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import fall2018.csc2017.GameCentre.slidingTiles.SlidingTilesBoard;
//import fall2018.csc2017.GameCentre.slidingTiles.SlidingTilesBoardManager;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
///**
// * Example local unit test, which will execute on the development machine (host).
// *
// * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
// */
//public class BoardManagerTest {
//
//    /** The board manager for testing. */
//    private SlidingTilesBoardManager boardManager;
//
//    private SlidingTilesBoard board;
//
//    /**
//     * Make a solved SudokuBoard.
//     */
//    @Before
//    private void setUpCorrect() {
//        List<Integer> tiles = makeTiles();
//        board = new SlidingTilesBoard(tiles, 3);
//        boardManager = new SlidingTilesBoardManager(board);
//    }
//
//    /**
//     *  whether swapping two tiles makes a solved board unsolved.
//     */
//    @Test
//    public void testIsSolved() {
////        swapFirstTwoTiles();
//        assertEquals(false, boardManager.boardSolved());
//    }
//
////    /**
////     *  whether swapping the first two tiles works.
////     */
////    @Test
////    public void testSwapFirstTwo() {
////        setUpCorrect();
////        assertEquals(1, boardManager.getBoard().getTile(0, 0).getId());
////        assertEquals(2, boardManager.getBoard().getTile(0, 1).getId());
////        boardManager.getBoard().swapTiles(0, 0, 0, 1);
////        assertEquals(2, boardManager.getBoard().getTile(0, 0).getId());
////        assertEquals(1, boardManager.getBoard().getTile(0, 1).getId());
////    }
////
////    /**
////     *  whether swapping the last two tiles works.
////     */
////    @Test
////    public void testSwapLastTwo() {
////        SlidingTilesBoard.NUM_ROWS = 4;
////        SlidingTilesBoard.NUM_COLS = 4;
////        setUpCorrect();
////        assertEquals(15, boardManager.getBoard().getTile(3, 2).getId());
////        assertEquals(16, boardManager.getBoard().getTile(3, 3).getId());
////        boardManager.getBoard().swapTiles(3, 3, 3, 2);
////        assertEquals(16, boardManager.getBoard().getTile(3, 2).getId());
////        assertEquals(15, boardManager.getBoard().getTile(3, 3).getId());
////    }
//
//    /**
//     *  whether isValidHelp works.
//     */
//    @Test
//    public void testIsValidTap() {
//        SlidingTilesBoard.NUM_ROWS = 4;
//        SlidingTilesBoard.NUM_COLS = 4;
//        setUpCorrect();
//        assertEquals(true, boardManager.isValidTap(11));
//        assertEquals(true, boardManager.isValidTap(14));
//        assertEquals(false, boardManager.isValidTap(10));
//    }
//
//
//    /**
//     * Generate an ArrayList of random tiles by the size.
//     */
//    private ArrayList<Integer> generateRandomNumber(int size){
//        ArrayList<Integer> listOfNum = new ArrayList<>();
//        for(int i = 1; i <= size*size; i++){
//            listOfNum.add(i);
//        }
//        Collections.shuffle(listOfNum);
//        return listOfNum;
//    }
////
////    private ArrayList<Tile> transformIntoTile(ArrayList<Integer> data){
////        ArrayList<Tile> theList = new ArrayList<>();
////        for(int i = 0; i < data.size(); i++){
////            theList.add(new Tile(data.get(i),data.get(i)-1));
////        }
////        return theList;
////    }
//
////    /**
////     * Make a 3X3 .
////     */
////    private void setUpCorrectThreeByThree(List<Tile> tiles) {
////        SlidingTilesBoard.NUM_COLS = 3;
////        SlidingTilesBoard.NUM_ROWS = 3;
////        SlidingTilesBoard board = new SlidingTilesBoard(tiles);
////        boardManager = new SlidingTilesBoardManager(board);
////    }
////
////    /**
////     * Make a 4X4 .
////     */
////    private void setUpCorrectFourByFour(List<Tile> tiles) {
////        SlidingTilesBoard.NUM_COLS = 4;
////        SlidingTilesBoard.NUM_ROWS = 4;
////        SlidingTilesBoard board = new SlidingTilesBoard(tiles);
////        boardManager = new SlidingTilesBoardManager(board);
////    }
////
////    /**
////     * Make a 5X5 .
////     */
////    private void setUpCorrectFiveByFive(List<Tile> tiles) {
////        SlidingTilesBoard.NUM_COLS = 5;
////        SlidingTilesBoard.NUM_ROWS = 5;
////        SlidingTilesBoard board = new SlidingTilesBoard(tiles);
////        boardManager = new SlidingTilesBoardManager(board);
////    }
//
//    /**
//     *  whether solvable method works.
//     */
//    @Test
//    public void testSolvableThreeByThree() {
//        ArrayList<Integer> listOfNum= generateRandomNumber(3);
//        ArrayList<Tile> listOfTile = transformIntoTile(listOfNum);
//        setUpCorrectThreeByThree(listOfTile);
//        if(boardManager.getTotalInversion(listOfNum)%2==0){
//            assertTrue(boardManager.solvable());
//        } else{
//            assertFalse(boardManager.solvable());
//        }
//    }
//
//    /**
//     *  whether solvable method works.
//     */
//    @Test
//    public void testSolvableFourByFour(){
//        ArrayList<Integer> listOfNum= generateRandomNumber(4);
//        ArrayList<Tile> listOfTile = transformIntoTile(listOfNum);
//        setUpCorrectFourByFour(listOfTile);
//        if(boardManager.getTotalInversion(listOfNum)%2==0){
//            if(boardManager.blankPosition()%2!=0){
//                assertTrue(boardManager.solvable());
//            }else{
//                assertFalse(boardManager.solvable());
//            }
//        } else{
//            if(boardManager.blankPosition()%2==0){
//                assertTrue(boardManager.solvable());
//            }else{
//                assertFalse(boardManager.solvable());
//            }
//        }
//    }
//
//    /**
//     *  whether solvable method works.
//     */
//    @Test
//    public void testSolvableFiveByFive() {
//        ArrayList<Integer> listOfNum= generateRandomNumber(5);
//        ArrayList<Tile> listOfTile = transformIntoTile(listOfNum);
//        setUpCorrectFiveByFive(listOfTile);
//        if(boardManager.getTotalInversion(listOfNum)%2==0){
//            assertTrue(boardManager.solvable());
//        } else{
//            assertFalse(boardManager.solvable());
//        }
//    }
//
//    /**
//     *  whether getTotalInversion method works.
//     */
//    @Test
//    public void testGetTotalInversionOddWidth(){
//        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1,8,2,9,4,3,7,6,5));
//        ArrayList<Tile> listOfTile = transformIntoTile(data);
//        setUpCorrectThreeByThree(listOfTile);
//        assertEquals(10, boardManager.getTotalInversion(data));
//    }
//
//    /**
//     *  whether getTotalInversion method works.
//     */
//    @Test
//    public void testGetTotalInversionEvenWidth(){
//        ArrayList<Integer> data_1 = new ArrayList<>(Arrays.asList(13,2,10,3,1,12,8,4,5,16,9,
//                6,15,14,11,7));
//        ArrayList<Tile> listOfTile = transformIntoTile(data_1);
//        setUpCorrectFourByFour(listOfTile);
//        assertEquals(41, boardManager.getTotalInversion(data_1));
//    }
//
//    /**
//     *  whether blankPosition method works.
//     */
//    @Test
//    public void testBlankPositionOddWidth(){
//        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1,8,2,9,4,3,7,6,5));
//        ArrayList<Tile> listOfTile = transformIntoTile(data);
//        setUpCorrectThreeByThree(listOfTile);
//        assertEquals(2, boardManager.blankPosition());
//    }
//
//    /**
//     *  whether blankPosition method works.
//     */
//    @Test
//    public void testBlankPositionEvenWidth(){
//        ArrayList<Integer> data_1 = new ArrayList<>(Arrays.asList(13,2,10,3,1,12,8,4,5,16,9,
//                6,15,14,11,7));
//        ArrayList<Tile> listOfTile = transformIntoTile(data_1);
//        setUpCorrectFourByFour(listOfTile);
//        assertEquals(2, boardManager.blankPosition());
//    }
//
//    private List<Integer> makeTiles() {
//        List<Integer> tiles = new ArrayList<>();
//        final int numTiles = . * SlidingTilesBoard.NUM_COLS;
//        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
//            tiles.add(new Tile(tileNum + 1, tileNum));
//        }
//
//        return tiles;
//    }
//
//
//    /**
//     * Shuffle a few tiles.
//     */
//    private void swapFirstTwoTiles() {
//        boardManager.getBoard().swapTiles(0, 0, 0, 1);
//    }
//
//
//
//}
//