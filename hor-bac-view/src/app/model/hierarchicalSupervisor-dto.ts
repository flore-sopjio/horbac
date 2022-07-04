export interface HierarchicalSupevisorDTO {
    nom?: string;
    organisationalUnit?: string;
    superieurH?: HierarchicalSupevisorDTO;
}
