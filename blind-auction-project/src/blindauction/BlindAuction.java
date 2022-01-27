package blindauction;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
// This program models blind auction type. Bidders place their without knowledge of other participants' bids.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlindAuction {

	public static void main(String[] args) throws IOException { 
		ASCIIART();
		auctionBidding();		
	}
	
	/**
	 *  This method keep asking asking as long as there are more bidders
	 * @throws IOException
	 */
    private static void auctionBidding() throws IOException {
    	Scanner scanner = new Scanner(System.in);
		boolean isBiddingFinished = false;
		Map<String, Float> bids = new HashMap<>();
		while (!isBiddingFinished) {
			System.out.print("What is your name?: ");
		    String name = scanner.next();
		    while(bids.containsKey(name)) {
		    	System.out.print("Name exists. Enter a different name?: ");
			    name = scanner.next(); //keep asking a bidder for a unique name
		    } 
		    System.out.print("What is your bid?: $");
		    float price = scanner.nextFloat();
		    bids.put(name, price);
		    System.out.println("Are there any other bidders? Type 'yes or 'no'.");
		    
		    String shouldContinue = scanner.next().toLowerCase();
		    System.out.println();
		    if (shouldContinue.equals("no")){
		    	isBiddingFinished = true;
		        findHighestBidder(bids);
		    } else if(shouldContinue.equals("yes")) {
		    	shouldContinue = "yes";
		    	System.out.print("\033\143"); // clears the terminal for next bidder. 
		    	//Next bidder can't see the previous bid
		    	ASCIIART();
		    }
		}
		scanner.close();
		
	}
	/**
     * checks who has the highest bids and declares him the winner
     * @param bids  key-pair value map containing bidders and their respective bids
     */
	private static void findHighestBidder(Map<String, Float> bids) {
		float highestBid = 0;
	    String winner = "";
	   
	    for(String bidder: bids.keySet()) {
	    	Float bidAmount = bids.get(bidder);
	    	if (bidAmount > highestBid) {
	    		highestBid = bidAmount;
	    	    winner = bidder;
	    	}
	    	            
	    }
       System.out.println("The winner is "+ winner + " with a bid of $" + highestBid);	
	}
	/**
	 * @author code.factory  use this code to display auction's ASCII image
	 * @throws IOException
	 */
	public static void ASCIIART() throws IOException {
		int width = 130;
		        int height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		        Graphics g = image.getGraphics();
		        g.setFont(new Font("SansSerif", Font.BOLD, 15));
		Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		        graphics.drawString("AUCTION", 10, 20);
		for (int y = 0; y < height; y++) {
		            StringBuilder sb = new StringBuilder();
		            for (int x = 0; x < width; x++) {
		                sb.append(image.getRGB(x, y) == -16777216 ? " " : "#");
		            }
		            if (sb.toString().trim().isEmpty()) {
		                continue;
		            }
		            System.out.println(sb);
		        }
		}

}
