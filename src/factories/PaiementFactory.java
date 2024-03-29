package factories;

import dao.*;

public class PaiementFactory extends AbstractFactory {
	
	public PaiementFactory() {}

	@Override
	public PaiementDaoImpl getPaiementDao (Class<? extends PaiementDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == PaiementDaoImpl.class) {
			return new PaiementDaoImpl ();
		} 
		
		return null;
	}
}
