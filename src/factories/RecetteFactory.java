package factories;

import dao.*;

public class RecetteFactory extends AbstractFactory {
	
	public RecetteFactory() {}

	@Override
	public RecetteDaoImpl getRecetteDao (Class<? extends RecetteDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == RecetteDaoImpl.class) {
			return new RecetteDaoImpl ();
		} 
		
		return null;
	}
}
