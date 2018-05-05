import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.*;
import javafx.scene.control.ScrollPane.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import java.io.*;
import javafx.scene.input.*;
import javax.swing.JOptionPane;
import javafx.animation.*;
import java.time.*;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import java.util.*;
import javafx.scene.media.AudioClip;
import javafx.collections.*;
import javafx.beans.value.*;
import java.text.*;

//Import complete---------------------

public class CalculatorUI extends Application
{
	//initialize global variables----------------------
	private TextField resultHolder;
	private Stage window;
	private Scene scene;
	private  DropShadow ds;
	private final double defaultNum=0;
	private BorderPane borderPane;
	private String keypadnums="";
	private Button b=null;
	private double result=0;
	private String sum;
	private String add,mul,div,sub;
	private ArrayList<String>numberToAdd=new ArrayList<String>();
	  int calcOperation = 0;
    double currentCalc;
    int colors=0;

	public static void main(String[] args) {
		launch(args);
	}
	@Override 
	public void start(Stage primaryStage)throws Exception
	{
		ds=new DropShadow();
		 ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);

		window=primaryStage;
		window.setTitle("Calculator");

		resultHolder=new TextField();
		resultHolder.getStyleClass().add("result");
		Group root=new Group();
		Scene sc=new Scene(root,350,550,Color.web("transparent"));
		sc.getStylesheets().add("calculatorUI.css");
		scene=sc;
		borderPane=new BorderPane();
		borderPane.getStyleClass().add("borderpane");
		resultHolder.setDisable(true);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		//	resultHolder.setTextAlignment(TextAlignment.RIGHT);
			StackPane stk=new StackPane();
			stk.getChildren().addAll(Keys());
			HBox mainHbox=new HBox();
			HBox box=new HBox();
			HBox box1=new HBox();
			stk.setAlignment(Keys(),Pos.TOP_CENTER);
			stk.setTranslateY(0);
			stk.setTranslateX(25);
			box1.getChildren().addAll(operatorKey());
			box1.setAlignment(Pos.CENTER);
			mainHbox.getChildren().addAll(stk,box1);
			//Keys().setTranslateX(60);
			mainHbox.setAlignment(Pos.CENTER);
			box.getChildren().add(resultHolder);
			box.setAlignment(Pos.CENTER);
			
			
			
			mainHbox.setSpacing(50);
			borderPane.setTop(box);

		borderPane.setCenter(mainHbox);

		root.getChildren().addAll(borderPane);
		
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}

	public CalculatorUI()
	{

	}
	public VBox operatorKey2()
	{
		VBox operatorContainer=new VBox();
		operatorContainer.getStyleClass().add("operatorBox");
		Button[]nums=new Button[4];

		nums[0]=new Button("x\u00B2");
		nums[0].getStyleClass().add("operator");
		nums[0].setEffect(ds);
		
		nums[1]=new Button("\u221A"+"x");
		nums[1].getStyleClass().add("operator");
		nums[1].setEffect(ds);
		
		nums[2]=new Button("x/y");
		nums[2].getStyleClass().add("operator");
		nums[2].setEffect(ds);
		
		nums[3]=new Button("%");
		nums[3].getStyleClass().add("operator");
		nums[3].setEffect(ds);

		operatorContainer.getChildren().addAll(nums[0],nums[1],nums[2],nums[3]);
		operatorContainer.setAlignment(Pos.CENTER);
		return operatorContainer;
			
		
	}
	
	public VBox operatorKey()
	{
		VBox operatorContainer=new VBox();
		operatorContainer.getStyleClass().add("operatorBox");
NumberFormat nf=new DecimalFormat("##.##");
		resultHolder.setPromptText(nf.format(defaultNum));

		Button[]nums=new Button[8];

		nums[0]=new Button("\u00D7");
		nums[0].getStyleClass().add("operator");
		nums[0].setEffect(ds);
		 OperatorAction multAction = new OperatorAction(3);
		 nums[0].setOnAction(e->{

		
				keypadnums="";
				multAction.handle(e);
				resultHolder.setText("");

			
		});
		
		nums[1]=new Button("\u00F7");
		nums[1].getStyleClass().add("operator");
		nums[1].setEffect(ds);
		 OperatorAction divAction = new OperatorAction(4);
		 nums[1].setOnAction(e->{

		
				keypadnums="";
				divAction.handle(e);
				resultHolder.setText("");

			
		});
		 OperatorAction subAction = new OperatorAction(2);
		nums[2]=new Button("-");
		nums[2].getStyleClass().add("operator");
		nums[2].setEffect(ds);
		nums[2].setOnAction(e->{

		
				keypadnums="";
				subAction.handle(e);
				resultHolder.setText("");

			
		});

		 
        OperatorAction addAction = new OperatorAction(1);
		nums[3]=new Button("+");
		nums[3].getStyleClass().add("operator");
		nums[3].setEffect(ds);
		nums[3].setOnAction(e->{

		
				keypadnums="";
				addAction.handle(e);
				resultHolder.setText("");

			
		});


		nums[4]=new Button("x\u00B2");
		nums[4].getStyleClass().add("operator");
		nums[4].setEffect(ds);
		OperatorAction powAction = new OperatorAction(5);
		nums[4].setOnAction(e->{

		
				keypadnums="";
				powAction.handle(e);
				double number=Double.parseDouble(resultHolder.getText());
				double calculate = number  * number;
				currentCalc=calculate;
                        resultHolder.setText(nf.format(calculate));
			
			
		});
		
		nums[5]=new Button("\u221A"+"x");
		nums[5].getStyleClass().add("operator");
		nums[5].setEffect(ds);
		OperatorAction sqrtAction = new OperatorAction(6);
		nums[5].setOnAction(e->{
					double number=Double.parseDouble(resultHolder.getText());
					double calculate = Math.sqrt(number);
                        resultHolder.setText(nf.format(calculate));
                        currentCalc=calculate;
		
				keypadnums="";
				sqrtAction.handle(e);
				//resultHolder.setPromptText("\u221A");

			
		});
		
		nums[6]=new Button("x/y");
		nums[6].getStyleClass().add("operator");
		nums[6].setEffect(ds);
		OperatorAction fractionAction = new OperatorAction(7);
		nums[6].setOnAction(e->{

		
				keypadnums="";
				fractionAction.handle(e);
				resultHolder.setText("");

			
		});
		
		nums[7]=new Button("%");
		nums[7].getStyleClass().add("operator");
		nums[7].setEffect(ds);
		OperatorAction modAction = new OperatorAction(8);
		nums[7].setOnAction(e->{

				double number=Double.parseDouble(resultHolder.getText());
					double calculate =number/100 ;
                        resultHolder.setText(nf.format(calculate));
                        currentCalc=calculate;
				keypadnums="";
				modAction.handle(e);
				

			
		});
		operatorContainer.getChildren().addAll(nums[0],nums[1],nums[2],nums[3],nums[4],nums[5],nums[6],nums[7]);
		operatorContainer.setAlignment(Pos.CENTER);
		return operatorContainer;
			
		
	}
	public VBox Keys()
	{
		VBox main=new VBox();
			Button back=new Button("\u21CD");
			back.getStyleClass().add("back");
			Button clear=new Button("CA");
			clear.getStyleClass().add("ca");
			clear.setEffect(ds);
			Button more=new Button("\u22EF");
			more.getStyleClass().add("more");
			back.setId("backb");
			StackPane stack=new StackPane();
			
		stack.getChildren().addAll(clear,more,back);
		more.setTranslateY(0);
		back.setTranslateY(-120);
		more.setTranslateX(-90);
		clear.setTranslateX(90);
		back.setTranslateX(150);
		back.setDisable((keypadnums.length()>1));
		back.setOnAction(e-> {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              goBack("s");
            
          }
          );
		clear.setOnAction(e->{
			keypadnums="";
			resultHolder.setText("");
		});
		
		stack.setAlignment(Pos.TOP_CENTER);
		NumberFormat nf=new DecimalFormat("##.##");
		resultHolder.setPromptText(nf.format(defaultNum));

		HBox allTools=new HBox();
		
		VBox numContainer=new VBox();
		numContainer.getStyleClass().add("numberBox");
		HBox colorContainer=new HBox();
		colorContainer.getStyleClass().add("colorBox");
		HBox[]rows=new HBox[4];
		rows[0]=new HBox();
		rows[1]=new HBox();
		rows[2]=new HBox();
		rows[3]=new HBox();
		Button[]nums=new Button[18];
		//Key board input
			kOperatorAction subAction = new kOperatorAction(2);
			kOperatorAction addAction = new kOperatorAction(1);
			kOperatorAction multAction = new kOperatorAction(3);
			kOperatorAction divAction = new kOperatorAction(4);
			kOperatorAction fractionAction = new kOperatorAction(7);
		 scene.setOnKeyPressed(new EventHandler<KeyEvent>()
       	{
       		@Override
       		public void handle(KeyEvent key)
       		{
       			NumberFormat nf=new DecimalFormat("##.##");
		resultHolder.setPromptText(nf.format(defaultNum));

       			
       			if(colors==1)
       			{
			       				main.setStyle("-fx-background-color:#ff4d4d;");
						borderPane.setStyle("-fx-background-color:#ff4d4d;");
						for(int i=1;i<10;i++)
					{
						
						nums[i-1].setStyle("-fx-text-fill:white;");
						nums[i-1].setId("numbersr");
							//nums[i-1].getStyleClass().clear();
						//	nums[i-1].getStyleClass().add("numbersr");
					}
					nums[10].setStyle("-fx-text-fill:white;");
						nums[10].setId("numbersr");back.setId("backw");
						
			    }
			    else if(colors==2)
			    {
						    			main.setStyle("-fx-background-color:#ffff66;");
						borderPane.setStyle("-fx-background-color:#ffff66;");
						for(int i=1;i<10;i++)
					{
						
						nums[i-1].setStyle("-fx-text-fill:black;");
					nums[i-1].setId("numbersy");
						//nums[i-1].getStyleClass().clear();
							//nums[i-1].getStyleClass().add("numbersy");
					}
					nums[10].setStyle("-fx-text-fill:black;");
					nums[10].setId("numbersy");back.setId("backw");
			    }
			    else if(colors==3)
			    {
							    	main.setStyle("-fx-background-color:#ccff66;");
							borderPane.setStyle("-fx-background-color:#ccff66;");
							for(int i=1;i<10;i++)
						{
							
							nums[i-1].setStyle("-fx-text-fill:white;");
						nums[i-1].setId("numbersg");
						//nums[i-1].getStyleClass().clear();
								//nums[i-1].getStyleClass().add("numbersg");
						}
						nums[10].setStyle("-fx-text-fill:white;");
						nums[10].setId("numbersg");back.setId("backw");
			    }
			    else if(colors==4)
			    {
						  main.setStyle("-fx-background-color:#80dfff;");
						borderPane.setStyle("-fx-background-color:#80dfff");
						
						for(int i=1;i<10;i++)
					{
						
						nums[i-1].setStyle("-fx-text-fill:white;");
					nums[i-1].setId("numbersb");
						//nums[i-1].getStyleClass().clear();
						//nums[i-1].getStyleClass().add("numbersb");
					}
					nums[10].setStyle("-fx-text-fill:white;");
					nums[10].setId("numbersb");back.setId("backw");
			    }
			      else if(colors==5)
			    {
							    			main.setStyle("-fx-background-color:black;");
			borderPane.setStyle("-fx-background-color:black;");
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:white;");
		nums[i-1].setId("numbersbk");
			//nums[i-1].getStyleClass().clear();
			//nums[i-1].getStyleClass().add("numbersbk");
		}nums[10].setStyle("-fx-text-fill:white;");
		nums[10].setId("numbersbk");
		back.setId("backw");
			    }
			      else if(colors==6)
			    {
						    			main.setStyle("-fx-background-color:white;");
						borderPane.setStyle("-fx-background-color:white;");
						for(int i=1;i<10;i++)
					{
						
						nums[i-1].setStyle("-fx-text-fill:black;");
					nums[i-1].setId("numbersbk");
						//nums[i-1].getStyleClass().clear();
						//nums[i-1].getStyleClass().add("numbersbk");
					}nums[10].setStyle("-fx-text-fill:black;");
					nums[10].setId("numbersbk");
					back.setId("backb");
			    }

       			if(key.getCode().equals(KeyCode.DIGIT0)||key.getCode().equals(KeyCode.NUMPAD0))
       				 keyPad("0");
       			else if(key.getCode().equals(KeyCode.DIGIT1)||key.getCode().equals(KeyCode.NUMPAD1))
       				 keyPad("1");
       			else if(key.getCode().equals(KeyCode.DIGIT2)||key.getCode().equals(KeyCode.NUMPAD2))
       				 keyPad("2");
       			else if(key.getCode().equals(KeyCode.DIGIT3)||key.getCode().equals(KeyCode.NUMPAD3))
       				 keyPad("3");
       			else if(key.getCode().equals(KeyCode.DIGIT4)||key.getCode().equals(KeyCode.NUMPAD4))
       				 keyPad("4");
       			else if(key.getCode().equals(KeyCode.DIGIT5)||key.getCode().equals(KeyCode.NUMPAD5))
       				 keyPad("5");
       			else if(key.getCode().equals(KeyCode.DIGIT6)||key.getCode().equals(KeyCode.NUMPAD6))
       				 keyPad("6");
       			else if(key.getCode().equals(KeyCode.DIGIT7)||key.getCode().equals(KeyCode.NUMPAD7))
       				 keyPad("7");
       			else if(key.getCode().equals(KeyCode.DIGIT8)||key.getCode().equals(KeyCode.NUMPAD8))
       				 keyPad("8");
       			else if(key.getCode().equals(KeyCode.DIGIT9)||key.getCode().equals(KeyCode.NUMPAD9))
       				 keyPad("9");
       			else if(key.getCode().equals(KeyCode.PERIOD)||key.getCode().equals(KeyCode.DECIMAL))
       				 keyPad(".");
       			else if(key.getCode().equals(KeyCode.RIGHT))
       				 {
       				 	if(colors>=6)
       				 		colors=6;
       				 	else
       				 		{
System.out.println(colors);
       				 			colors=colors+1;}

       				 	System.out.println(colors);
       				 }
       			else if(key.getCode().equals(KeyCode.LEFT))
       				 {
       				 	if(colors<=0)
       				 		colors=0;
       				 	else
       				 		colors=colors-1;
       				 	System.out.println(colors);
       				 }
       		

       			else if(key.getCode().equals(KeyCode.SLASH)||key.getCode().equals(KeyCode.DIVIDE))
       			{
       				keypadnums="";
					divAction.handle(key);
					resultHolder.setText("");
       			}
       			else if(key.getCode().equals(KeyCode.ASTERISK)||key.getCode().equals(KeyCode.MULTIPLY))
       			{

		
					keypadnums="";
					multAction.handle(key);
					resultHolder.setText("");

		
       			}	
       			else if(key.getCode().equals(KeyCode.ADD)||key.getCode().equals(KeyCode.ADD))
						{

							keypadnums="";
							addAction.handle(key);
							resultHolder.setText("");
						}       				
       			else if(key.getCode().equals(KeyCode.MINUS)||key.getCode().equals(KeyCode.SUBTRACT))
       				{
       						keypadnums="";
							subAction.handle(key);
							resultHolder.setText("");

       				}
       			else if(key.getCode().equals(KeyCode.DELETE))
       				 {
       				 	keypadnums="";
						resultHolder.setText("");
       				 }
       			else if(key.getCode().equals(KeyCode.ENTER)||key.getCode().equals(KeyCode.SEPARATOR)||key.getCode().equals(KeyCode.EQUALS)||key.getCode().equals(KeyCode.SPACE))
       			{
       					if (!resultHolder.getText().isEmpty());
                {
                    double number = Double.parseDouble(resultHolder.getText()); 
                    if (calcOperation == 1)
                    {
                        double calculate = currentCalc  + number;
                        resultHolder.setText(nf.format(calculate));
                    }
                    else if (calcOperation == 2)
                    {
                      	double calculate = currentCalc  - number;
                        resultHolder.setText(nf.format(calculate));
                    }
                      else if (calcOperation == 3)
                    {
                      	double calculate = currentCalc  * number;
                        resultHolder.setText(nf.format(calculate));
                    }
                      else if (calcOperation == 4)
                    {
                    	try{
                      			double calculate = currentCalc  / number;
                        		resultHolder.setText(nf.format(calculate));
                    		}
                    		catch(NumberFormatException nfe)
                    		{
                    			System.out.println("caught Exception: "+nfe);
                    			resultHolder.setStyle("-fx-background-color:red;-fx-text-fill:white");
                    			resultHolder.setText("Error");
                    		}
                    }
                  
                     
                      else if (calcOperation == 7)
                    {
                      	double calculate =number/number;
                        resultHolder.setText(nf.format(calculate));
                    }
                     

                }
       			}
       			
       			

       			
       		}
        });



		
		//main.setPadding(new Insets(20, 0, 0, 20));
	
		for(int i=1;i<10;i++)
		{

			nums[i-1]=new Button(i+"");
			nums[i-1].getStyleClass().add("numbers");
			nums[i-1].setStyle("-fx-text-fill:black;");
		nums[i-1].setId("numbersbk");
			nums[i-1].setOnAction(e-> {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              keyPad(b.getText());
            
          }
          );
			
		//	nums[i].setOnAction();
			//nums[i]=numb[i].setText(i);
			//nums[i-1].setEffect(ds);
		}

		nums[9]=new Button(".");
		nums[9].getStyleClass().add("decimal");
		nums[9].setOnAction(e-> {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              keyPad(b.getText());
            
          }
          );
		//nums[9].setEffect(ds);
		nums[10]=new Button("0");
		nums[10].getStyleClass().add("numbers");
		nums[10].setOnAction(e-> {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              keyPad(b.getText());
            
          }
          );
		//nums[10].setEffect(ds);
		nums[11]=new Button("=");
		nums[11].getStyleClass().add("equals");
		nums[11].setOnAction(e->{
			if (!resultHolder.getText().isEmpty())
                {
                    double number = Double.parseDouble(resultHolder.getText()); 
                    if (calcOperation == 1)
                    {
                        double calculate = currentCalc  + number;
                        resultHolder.setText(nf.format(calculate));
                    }
                    else if (calcOperation == 2)
                    {
                      	double calculate = currentCalc  - number;
                        resultHolder.setText(nf.format(calculate));
                    }
                      else if (calcOperation == 3)
                    {
                      	double calculate = currentCalc  * number;
                        resultHolder.setText(nf.format(calculate));
                    }
                      else if (calcOperation == 4)
                    {
                    	try{
                      			double calculate = currentCalc  / number;
                        		resultHolder.setText(nf.format(calculate));
                    		}
                    		catch(NumberFormatException nfe)
                    		{
                    			System.out.println("caught Exception: "+nfe);
                    			resultHolder.setStyle("-fx-background-color:red;-fx-text-fill:white");
                    			resultHolder.setText("Error");
                    		}
                    }
                  
                     
                      else if (calcOperation == 7)
                    {
                      	double calculate =number/number;
                        resultHolder.setText(nf.format(calculate));
                    }
                     

                }
		});

		//nums[11].setEffect(ds);

		
		nums[12]=new Button();
		nums[12].getStyleClass().add("redButton");
		nums[12].setOnAction(e->{
			main.setStyle("-fx-background-color:#ff4d4d;");
			borderPane.setStyle("-fx-background-color:#ff4d4d;");
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:white;");
			nums[i-1].setId("numbersr");
				//nums[i-1].getStyleClass().clear();
			//	nums[i-1].getStyleClass().add("numbersr");
		}
		nums[10].setStyle("-fx-text-fill:white;");
			nums[10].setId("numbersr");back.setId("backw");
			

		});

		nums[13]=new Button();
		nums[13].getStyleClass().add("yellowButton");
		nums[13].setOnAction(e->{
			main.setStyle("-fx-background-color:#ffff66;");
			borderPane.setStyle("-fx-background-color:#ffff66;");
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:black;");
		nums[i-1].setId("numbersy");
			//nums[i-1].getStyleClass().clear();
				//nums[i-1].getStyleClass().add("numbersy");
		}
		nums[10].setStyle("-fx-text-fill:black;");
		nums[10].setId("numbersy");back.setId("backw");
			

		});
		nums[14]=new Button();
		nums[14].getStyleClass().add("greenButton");
		nums[14].setOnAction(e->{
			main.setStyle("-fx-background-color:#ccff66;");
			borderPane.setStyle("-fx-background-color:#ccff66;");
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:white;");
		nums[i-1].setId("numbersg");
		//nums[i-1].getStyleClass().clear();
				//nums[i-1].getStyleClass().add("numbersg");
		}
		nums[10].setStyle("-fx-text-fill:white;");
		nums[10].setId("numbersg");back.setId("backw");
		});
		nums[15]=new Button();
		nums[15].getStyleClass().add("blueButton");
		nums[15].setOnAction(e->{
			main.setStyle("-fx-background-color:#80dfff;");
			borderPane.setStyle("-fx-background-color:#80dfff");
			
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:white;");
		nums[i-1].setId("numbersb");
			//nums[i-1].getStyleClass().clear();
			//nums[i-1].getStyleClass().add("numbersb");
		}
		nums[10].setStyle("-fx-text-fill:white;");
		nums[10].setId("numbersb");back.setId("backw");
		});

		nums[16]=new Button();
		nums[16].getStyleClass().add("blackButton");
		nums[16].setOnAction(e->{
			main.setStyle("-fx-background-color:black;");
			borderPane.setStyle("-fx-background-color:black;");
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:white;");
		nums[i-1].setId("numbersbk");
			//nums[i-1].getStyleClass().clear();
			//nums[i-1].getStyleClass().add("numbersbk");
		}nums[10].setStyle("-fx-text-fill:white;");
		nums[10].setId("numbersbk");
		back.setId("backw");
			

		});
		nums[17]=new Button();
		nums[17].getStyleClass().add("whiteButton");
		nums[17].setOnAction(e->{
			main.setStyle("-fx-background-color:white;");
			borderPane.setStyle("-fx-background-color:white;");
			for(int i=1;i<10;i++)
		{
			
			nums[i-1].setStyle("-fx-text-fill:black;");
		nums[i-1].setId("numbersbk");
			//nums[i-1].getStyleClass().clear();
			//nums[i-1].getStyleClass().add("numbersbk");
		}nums[10].setStyle("-fx-text-fill:black;");
		nums[10].setId("numbersbk");
		back.setId("backb");
			

		});
		nums[10].setStyle("-fx-text-fill:black;");
		nums[10].setId("numbersbk");
		rows[0].getChildren().addAll(nums[6],nums[7],nums[8]);
		rows[0].setAlignment(Pos.CENTER);
		
		rows[1].getChildren().addAll(nums[3],nums[4],nums[5]);
		rows[1].setAlignment(Pos.CENTER);
		
		rows[2].getChildren().addAll(nums[0],nums[1],nums[2]);
		rows[2].setAlignment(Pos.CENTER);
		
		rows[3].getChildren().addAll(nums[9],nums[10],nums[11]);
		rows[3].setAlignment(Pos.CENTER);
		

		numContainer.getChildren().addAll(rows[0],rows[1],rows[2],rows[3]);
		//numContainer.setEffect(ds);
		//numContainer.setAlignment(Pos.CENTER);
		
		colorContainer.getChildren().addAll(nums[12],nums[13],nums[14],nums[15],nums[16],nums[17]);
		colorContainer.setAlignment(Pos.BOTTOM_CENTER);
		colorContainer.setSpacing(20);
		colorContainer.setTranslateY(30);

		allTools.getChildren().addAll(numContainer);
			allTools.setAlignment(Pos.CENTER);
		main.getChildren().addAll(stack,allTools,colorContainer);
		main.setAlignment(Pos.CENTER);


		return main;
	}
	 private void keyPad(String n)
        {
           
                keypadnums+=n;
                resultHolder.setText(keypadnums);

            
        }
      private void goBack()
      {
      	StringBuilder deleter=new StringBuilder(keypadnums);
      	if(!(keypadnums.equals(""))||keypadnums!=null)
      	{
      		deleter.deleteCharAt(keypadnums.length()-1);
     		keypadnums+=deleter+"";
      		resultHolder.setText(keypadnums);
      		System.out.println(keypadnums);
      	}
      	resultHolder.setText(0+"");
      	
      }
      private void goBack(String s)
      {
      	System.out.println(keypadnums);
      	if(keypadnums.length()>=1)
      	{
      		System.out.println();
      		keypadnums=keypadnums.substring(0,keypadnums.length()-1);
      		if(keypadnums.length()==1)
      			keypadnums=0+"";

      	}
      	
      	resultHolder.setText(keypadnums);
      }
      private double add()
      {
      	System.out.println(numberToAdd.size());
      	if(numberToAdd.size()>=2)
      	{
      		for(int i=0;i<numberToAdd.size();i++)
      		{
      			System.out.println(numberToAdd.get(i));
      			result+=Double.parseDouble(numberToAdd.get(i));
      			numberToAdd.clear();
      			numberToAdd.add(result+"");
      			result=0;
      			System.out.println(result);
      		}
      	}
      	return result;
      }
      private void getResult()
      {
      	NumberFormat nf=new DecimalFormat("##.##");
		


      	resultHolder.setText(nf.format(add()));
      }
     
    
    private class OperatorAction implements EventHandler<ActionEvent>
    {
        private int operator;
        
        public OperatorAction(int operation)
        {
            operator = operation;
        }
        
        public void handle(ActionEvent event)
        {
            currentCalc = Double.parseDouble(resultHolder.getText()); 
            calcOperation = operator;
        }
    }
    private class kOperatorAction implements EventHandler<KeyEvent>
    {
        private int operator;
        
        public kOperatorAction(int operation)
        {
            operator = operation;
        }
        
        public void handle(KeyEvent event)
        {
            currentCalc = Double.parseDouble(resultHolder.getText()); 
            calcOperation = operator;
        }
    }


}