/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.IO;

import Asteroid.GameObjects.Constant;
import Login.User;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author KelvinOjeda
 */
public class JSONParser {
    public static ArrayList<User> readField() throws FileNotFoundException{
        // ScoreData is the array where we can read the core from file
        ArrayList <User> dataList = new ArrayList<User>();
        
        File file = new File(Constant.SCORE_PATH);
        // If the file is empty or is not exist return the dataList
         if(!file.exists() || file.length() == 0){
             return dataList;
         }
         // Start to parser
         JSONTokener parser = new JSONTokener(new FileInputStream(file));
         //Initial the JSONArray
         JSONArray jsonList = new JSONArray(parser);
         
         for (int i = 0; i < jsonList.length(); i++){
             JSONObject jsonObject = (JSONObject) jsonList.get(i);
             User userData = new User();
             userData.setFirstName(jsonObject.getString("fistName"));
             userData.setLastName(jsonObject.getString("lastName"));
             userData.setId(jsonObject.getString("id"));
             userData.setPassword(jsonObject.getString("password"));
             userData.setAsteroidGameScore(jsonObject.getInt("asteroidGameScore"));
             userData.setSnailGameScore(jsonObject.getInt("snailGameScore"));
             userData.setTetrisGameScore(jsonObject.getInt("tetrisGameScore"));
             userData.setSnakeGameScore(jsonObject.getInt("snakeGameScore"));
             userData.setDate(jsonObject.getString("date"));
             userData.setCurrentActive(jsonObject.getInt("currentActive"));
             dataList.add(userData);
         }
         
         return dataList;
         
         
    }
    
    public static void writeFile(ArrayList<User> dataList) throws IOException{
        File outputFile = new File(Constant.SCORE_PATH);
        // Create the parent directory
        outputFile.getParentFile().mkdir();
        // Create the file into the parent directory
        outputFile.createNewFile();
        
        JSONArray jsonList = new JSONArray();
         for (User user : dataList){
             JSONObject jsonObject = new JSONObject();
             jsonObject.put("fistName", user.getFirstName());
             jsonObject.put("lastName", user.getLastName());
             jsonObject.put("id", user.getId());
             jsonObject.put("password", user.getPassword());
             jsonObject.put("asteroidGameScore", user.getAsteroidGameScore());
             jsonObject.put("snailGameScore", user.getSnailGameScore());
             jsonObject.put("tetrisGameScore", user.getTetrisGameScore());
             jsonObject.put("snakeGameScore", user.getSnakeGameScore());
             jsonObject.put("date", user.getDate());
             jsonObject.put("currentActive", user.getCurrentActive());
             jsonList.put(jsonObject);
         }
         // Create the buffer to write
         BufferedWriter bufferWriter = Files.newBufferedWriter(
                 Paths.get(outputFile.toURI()));
         
         jsonList.write(bufferWriter);
         bufferWriter.close();
         
         
                 
        
        
    }
    
    
}
