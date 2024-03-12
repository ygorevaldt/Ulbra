export default interface IUseCase<In, Out> {
    execute(params: In): Out
}