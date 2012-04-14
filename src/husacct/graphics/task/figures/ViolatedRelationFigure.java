package husacct.graphics.task.figures;

import husacct.common.dto.DependencyDTO;
import husacct.common.dto.ViolationDTO;

public class ViolatedRelationFigure extends RelationFigure 
		implements IViolatedFigure
{
	private ViolationDTO[] violationDTOs;

	public ViolatedRelationFigure(DependencyDTO dependencyDTO, 
			ViolationDTO[] violationDTOs)
	{
		super(dependencyDTO);
		
		this.violationDTOs = violationDTOs;
	}

	@Override
	public ViolationDTO[] getViolations() 
	{
		return this.violationDTOs;
	}

}
