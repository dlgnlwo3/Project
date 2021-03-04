package pages;

import buy.BuyAction;
import buy.BuyDeleteAction;
import buy.BuyDetailAction;
import buy.BuyReplyDeleteAction;
import buy.BuyReplyWriteAction;
import buy.BuySearchAction;
import buy.BuyUpdateAction;
import buy.BuyUpdateFormAction;
import buy.BuyWriteAction;
import buy.BuyWriteFormAction;
import sell.SellAction;
import sell.SellDeleteAction;
import sell.SellDetailAction;
import sell.SellReplyDeleteAction;
import sell.SellReplyWriteAction;
import sell.SellUpdateAction;
import sell.SellUpdateFormAction;
import sell.SellWriteAction;
import sell.SellWriteFormAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	public ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("buy")) {
			action = new BuyAction();
		}else if(command.equals("buy-write-form")) {
			action = new BuyWriteFormAction();
		}else if(command.equals("buy-write")) {
			action = new BuyWriteAction();
		}else if(command.equals("buy-detail")) {
			action = new BuyDetailAction();
		}else if(command.equals("buy-update-form")) {
			action = new BuyUpdateFormAction();
		}else if(command.equals("buy-update")) {
			action = new BuyUpdateAction();
		}else if(command.equals("buy-delete")) {
			action = new BuyDeleteAction();
		}else if(command.equals("buy-reply-write")) {
			action = new BuyReplyWriteAction();
		}else if(command.equals("buy-reply-delete")) {
			action = new BuyReplyDeleteAction();
		}else if(command.equals("buy-search")) {
			action = new BuySearchAction();
		}else if(command.equals("sell")) {
			action = new SellAction();
		}else if(command.equals("sell-write-form")) {
			action = new SellWriteFormAction();
		}else if(command.equals("sell-write")) {
			action = new SellWriteAction();
		}else if(command.equals("sell-detail")) {
			action = new SellDetailAction();
		}else if(command.equals("sell-update-form")) {
			action = new SellUpdateFormAction();
		}else if(command.equals("sell-update")) {
			action = new SellUpdateAction();
		}else if(command.equals("sell-delete")) {
			action = new SellDeleteAction();
		}else if(command.equals("sell-reply-write")) {
			action = new SellReplyWriteAction();
		}else if(command.equals("sell-reply-delete")) {
			action = new SellReplyDeleteAction();
		}
		
				
		return action;
	}
	
}
