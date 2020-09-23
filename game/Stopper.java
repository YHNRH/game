package game;

import game.core.GameObject;

import java.util.concurrent.CopyOnWriteArrayList;

public class Stopper
{
    public static int rightCheck(int PlX,int PlY, int ObjX, int ObjY, int PlWi, int ObjHe, int PlHe, int ObjWi, int step)
    {
	if((PlY+80<=ObjY+ObjHe) && (PlY+PlHe>=ObjY))
	    if  (PlX+PlWi+step<ObjX || PlX +step > ObjX+ObjWi)
		return 0;
	    else 
		return 1;  
	else 
	    return 0;  
    }
    public static int leftCheck(int PlX,int PlY, int ObjX, int ObjY, int ObjWi, int ObjHe, int PlHe, int PlWi, int step)
    {
	if((PlY+80<=ObjY+ObjHe) && (PlY+PlHe>=ObjY))
	    if (PlX-step>ObjX+ObjWi || PlX + PlWi -step < ObjX)
		return 0;
	    else
		return 1;
	else
	    return 0;
  
    }
  
    public static int topCheck(int PlX,int PlY, int ObjX, int ObjY, int PlWi, int ObjWi, int PlHe, int ObjHe, int step)
    {
	if((PlX+PlWi>=ObjX) && (PlX<=ObjX+ObjWi))
	    if  (PlY+80-step>ObjY+ObjHe || PlY+PlHe-step<ObjY)
		return 0;
	    else
		return 1;
	else
	    return 0;
    }

    /*public static int botCheck(int PlX,int PlY, int ObjX, int ObjY, int ObjWi, int PlWi, int PlHe,  int ObjHe, int step)
    {
	if((PlX+PlWi>=ObjX) && (PlX<=ObjX+ObjWi))
	    if  (PlY+PlHe+step< ObjY || PlY+80+step>ObjY+ObjHe)
		return 0;
	    else
		return 1;
	else
	    return 0;
    }

    */

    public static int botCheck(GameObject pl, GameObject obj, int step)
    {
	if((pl.getPosx()+pl.getWidth()>=obj.getPosx()) && (pl.getPosx()<=obj.getPosx()+obj.getWidth()))
	    if  (pl.getPosy()+pl.getHeight()+step< obj.getPosy() || pl.getPosy()+80+step>obj.getPosy()+obj.getHeight())
		return 0;
	    else
		return 1;
	else
	    return 0;
    }

    


    // Эти методы ниже специально переопределены, чтобы столкновения обрабатывались на весь хитбокс, а не на полоску внизу (для монет)




    public static int rightCheck(int PlX,int PlY, int ObjX, int ObjY, int PlWi, int ObjHe, int PlHe, int ObjWi)
    {
	if((PlY<=ObjY+ObjHe) && (PlY+PlHe>=ObjY))
	    if  (PlX+PlWi+1<ObjX || PlX +1 > ObjX+ObjWi)
		return 0;
	    else 
		return 1;  
	else 
	    return 0;  
    }
    public static int leftCheck(int PlX,int PlY, int ObjX, int ObjY, int ObjWi, int ObjHe, int PlHe, int PlWi)
    {
	if((PlY<=ObjY+ObjHe) && (PlY+PlHe>=ObjY))
	    if (PlX-1>ObjX+ObjWi || PlX + PlWi -1 < ObjX)
		return 0;
	    else
		return 1;
	else
	    return 0;
  
    }



    public static int topCheck(int PlX,int PlY, int ObjX, int ObjY, int PlWi, int ObjWi, int PlHe, int ObjHe)
    {
	if((PlX+PlWi>=ObjX) && (PlX<=ObjX+ObjWi))
	    if  (PlY-1>ObjY+ObjHe || PlY+PlHe-1<ObjY)
		return 0;
	    else
		return 1;
	else
	    return 0;
    }

    public static int botCheck(int PlX,int PlY, int ObjX, int ObjY, int ObjWi, int PlWi, int PlHe,  int ObjHe)
    {
	if((PlX+PlWi>=ObjX) && (PlX<=ObjX+ObjWi))
	    if  (PlY+PlHe+1< ObjY || PlY+1>ObjY+ObjHe)
		return 0;
	    else
		return 1;
	else
	    return 0;
    }





    

    public static int fullCheck(int PlX,int PlY, int ObjX, int ObjY, int ObjWi, int PlWi, int PlHe,  int ObjHe)
    {
	if (
	    Stopper.leftCheck(PlX, PlY, ObjX, ObjY, ObjWi,ObjHe, PlHe, PlWi)==1
	    ||
	    Stopper.rightCheck(PlX,PlY, ObjX, ObjY,  PlWi,  ObjHe, PlHe, ObjWi)==1
	    ||
	    Stopper.botCheck(PlX,PlY, ObjX, ObjY, ObjWi, PlWi, PlHe,  ObjHe)==1
	    ||
	    Stopper.topCheck(PlX,PlY, ObjX, ObjY,  PlWi, ObjWi, PlHe,  ObjHe)==1
	    )
	    return 1;
	else
	    return 0;
	// 1 возвращается, если есть пересечение объектов
    }


    public static int rLeftCheck(CopyOnWriteArrayList<GameObject> array, GameObject player)
    {
	int c = 0;
	int step = 1;
	int a = 0;
	while (step<6)
	    {
		for (GameObject obj : array)
		    if (a != 1)
			{
			    if (Stopper.leftCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), obj.getWidth(), obj.getHeight(), player.getHeight(), player.getWidth(), 2*step)==0)
				c = step;
			    else
				{
				    c = step - 1;
				    a = 1;
				    step+=100;
				}
			}
		step++;
	    }

	return c;
    }

    public static int rRightCheck(CopyOnWriteArrayList<GameObject> array, GameObject player)
    {
	int c = 0;
	int step =1;
	int a = 0;
	while (step<6)
	    {
		for (GameObject obj : array)
		    if (a != 1)
			{
			    if (Stopper.rightCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), player.getWidth(), obj.getHeight(), player.getHeight(), obj.getWidth(), 2*step)==0)
				c = step;
			    else
				{
				    c = step -1;
				    a = 1;
				    step+=100;
				}
			}
		step++;
	    }

	return c;
    }

    public static int rTopCheck(CopyOnWriteArrayList<GameObject> array, GameObject player)
    {
	int c = 0;
	int step = 1;
	int a = 0;
	while (step<6)
	    {
		for (GameObject obj : array)
		    if (a != 1){
			if (Stopper.topCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), player.getWidth(), obj.getWidth(), player.getHeight(), obj.getHeight(), step)==0)
			    c = step;
			else
			    {
				c = step - 1;
				a = 1;
				step+=100;
			    }
		    }
		step++;
	    }
	return c;
	
    }

    public static int rBotCheck(CopyOnWriteArrayList<GameObject> array, GameObject player)
    {
		      int c = 0;
					      int step = 1;
					      int a = 0;
					      while (step<6)
						  {
						      for (GameObject obj : array)
							  if (a != 1)
							      {
								  if (Stopper.botCheck(player, obj, step)==0)
								      c = step;
								  else
								      {
									  c = step - 1;
									  a =1;
									  step+=100;
								      }
							      }
						      step++;
						  }
					      return c;
    }
     
    
}
