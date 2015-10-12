public class Permutations {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>> ();
        
        List<Integer> currentNums=new ArrayList<Integer>(Arrays.asList(nums));
        //the size of the list returned from asList() is fixed.
        // ArrayList(Collection < ? extends E > c) : Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
        List<Integer> list=new ArrayList<Integer>();
        permute(currentNums,list);  
        
    }
    private void permute(List<Integer> currentNums, List<Integer> list) {
        if(currentNums.size()==0){  //no more numbers.
        //now list is a list of numbers like [2,1,2]
            LinkedList<Integer> newList = new LinkedList<>();
            newList.addAll(list);
            result.add(newList);        //if return list directly: sent by reference.
            return;
        }
        for(int i=0;i<currentNums.size();i++){
            int candidate = currentNums.get(i);
            currentNums.remove(i);  //remove index.
            list.add(i);
            permute(currentNums,list);  //run the i+1 to size-1
            list.remove(list.size()-1); //last element
            current.add(i,candidate);
        }
    }
}